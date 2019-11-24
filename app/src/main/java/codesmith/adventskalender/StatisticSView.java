package codesmith.adventskalender;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.TableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

class StatisticSView {
    private static final String[] tableHeaders = {"Name", "gelöst am", "Versuche"};
    private String day;
    //    private LocalResult result;
    private Context context;
    private String restApiKey;
    private String restQuestionId;
    private String restUserName;
    private String restTrials;
    private String restDateTime;


    StatisticSView(Context context, String day) {
        this.context = context;
//        this.result = result;
        this.day = day;
        this.restApiKey = context.getResources().getString(R.string.rest_api_key);
        this.restQuestionId = context.getResources().getString(R.string.rest_question);
        this.restUserName = context.getResources().getString(R.string.rest_name);
        this.restTrials = context.getResources().getString(R.string.rest_trials);
        this.restDateTime = context.getResources().getString(R.string.rest_datetime);

    }


    void build_stats(JSONArray json_array) throws JSONException {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // view needs to be inflated, so that "findViewById" does find an element
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.statitics_view, null);
        builder.setView(view);
        // notice to user if no stats are available

        List<Result> results = new ArrayList<>();
        for (int i = 0; i < json_array.length(); i++) {
            JSONObject json_object = json_array.getJSONObject(i);
            results.add(new Result(json_object.getString(restUserName), json_object.getString(restDateTime), json_object.getString(restTrials)));
        }

        SortableTableView<Result> tableView = view.findViewById(R.id.statisticTableView);
        tableView.setColumnComparator(0, new ResultNameComparator());
        tableView.setColumnComparator(1, new ResultDateComparator());
        tableView.setColumnComparator(2, new ResultTrialsComparator());
        tableView.setDataAdapter(new ResultTableDataAdapter(context, results));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(context, tableHeaders));
        builder.setPositiveButton("Zurück zum Kalender", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ((Activity) context).finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    void postData(final LocalResult result) throws JSONException {
        final ProgressDialog progress = new ProgressDialog(context);
        progress.setTitle("Loading");
        progress.setMessage("Warte auf Server...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();

        String mpf = context.getResources().getString(R.string.MyPrefsFile);
        SharedPreferences settings = context.getSharedPreferences(mpf, 0);
        String userName = settings.getString(context.getResources().getString(R.string.user_name), "Unbekannt");

        JSONObject jsonBody = new JSONObject();
        //jsonBody.put("api_key", "123");
        jsonBody.put(restApiKey, context.getResources().getString(R.string.SECRET_API_KEY));
        jsonBody.put(restQuestionId, day);
        jsonBody.put(restUserName, userName);
        jsonBody.put(restTrials, result.get_trials());
//        jsonBody.put("solved_date", JSONObject.NULL);
        jsonBody.put(restDateTime, result.get_solved_date());
        final String requestBody = jsonBody.toString();

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://advent-calendar-data-api.herokuapp.com/get_results";
//        String url = "http://172.22.33.173:8001/get_results";
//        String url = "http://192.168.178.45:8001/get_results";

        JsonArrayRequest postRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response", response.toString());
                        try {
                            build_stats(response);
                            progress.dismiss();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", "Error: " + error.getMessage());
                        progress.dismiss();
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Die Antwort dauert zu lange oder ist fehlgeschlagen...");
                        builder.setPositiveButton("Zurück zum Kalender", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                ((Activity) context).finish();
                            }
                        });
                        builder.setNegativeButton("Erneut probieren", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                try {
                                    postData(result);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }
                }
        ) {

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() {
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }

        };

        // Add the request to the RequestQueue.
        //todo waiting animation
        queue.add(postRequest);

    }

    public class ResultTableDataAdapter extends TableDataAdapter<Result> {

        public ResultTableDataAdapter(Context context, List<Result> data) {
            super(context, data);
        }

        View renderUserName(Result result) {
            TextView tv = new TextView(context);
            tv.setText(result.user_name);
            tv.setGravity(Gravity.CENTER);
            return tv;
        }

        View renderDatetime(Result result) {
            ZonedDateTime zdt = ZonedDateTime.parse(result.solved_date);
            String newFormat = zdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            TextView tv = new TextView(context);
            tv.setGravity(Gravity.CENTER);
            tv.setText(newFormat);
            return tv;
        }

        View renderTrials(Result result) {
            TextView tv = new TextView(context);
            tv.setText(result.trials);
            tv.setGravity(Gravity.CENTER);
            return tv;
        }

        @Override
        public View getCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
            Result result = getRowData(rowIndex);
            View renderedView = null;

            switch (columnIndex) {
                case 0:
                    renderedView = renderUserName(result);
                    break;
                case 1:
                    renderedView = renderDatetime(result);
                    break;
                case 2:
                    renderedView = renderTrials(result);
                    break;
            }

            return renderedView;
        }

    }

    private static class ResultDateComparator implements Comparator<Result> {
        @Override
        public int compare(Result result1, Result result2) {
            return result1.solved_date.compareTo(result2.solved_date);
        }
    }

    private static class ResultTrialsComparator implements Comparator<Result> {
        @Override
        public int compare(Result result1, Result result2) {
            return result1.trials.compareTo(result2.trials);
        }
    }

    private static class ResultNameComparator implements Comparator<Result> {
        @Override
        public int compare(Result result1, Result result2) {
            return result1.user_name.compareTo(result2.user_name);
        }
    }


}
