package codesmith.adventskalender;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
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

import java.io.UnsupportedEncodingException;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;

class StatisticSView {
    private String day;
    private Result result;
    private Context context;
    private String restApiKey;
    private String restQuestionId;
    private String restUserName;
    private String restTrials;
    private String restDateTime;


    StatisticSView(Context context, String day, Result result) {
        this.context = context;
        this.result = result;
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
        //user notice if no stats are available
        String[][] table_data = new String[json_array.length()][];
        for (int i = 0; i < json_array.length(); i++) {
            JSONObject json_object = json_array.getJSONObject(i);
            String[] arr = {json_object.getString(restUserName),
                    json_object.getString(restDateTime),
                    json_object.getString(restTrials)};
            table_data[i] = arr;
        }

        TableView<String[]> tableView = view.findViewById(R.id.statisticTableView);
        tableView.setDataAdapter(new SimpleTableDataAdapter(context, table_data));

        builder.setPositiveButton("Genug", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    void postData() throws JSONException {
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
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", "Error: " + error.getMessage());
                        //todo error in app zeigen

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
        queue.add(postRequest);

    }


}
