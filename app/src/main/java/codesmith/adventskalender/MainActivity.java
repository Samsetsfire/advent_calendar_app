package codesmith.adventskalender;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jakewharton.threetenabp.AndroidThreeTen;

import org.json.JSONException;


public class MainActivity extends Activity {
    public Activity activity;
    public boolean FrageSuspendsMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidThreeTen.init(this);
        setContentView(R.layout.activity_main);
        FrageSuspendsMusic = false;

        //Muss hier nochmal stehen, weil ueber on ActivityResult die Musik nicht beendet wird...
        if (AudioPlay.isplayingAudio) {
            AudioPlay.stopAudio();
        }
        AudioPlay.playAudio(this, R.raw.winterbells);

        String mpf = getResources().getString(R.string.MyPrefsFile);
        SharedPreferences settings = getSharedPreferences(mpf, 0);

        Boolean z01 = settings.getBoolean("codesmith.adventskalender:id/z01", false);
        Boolean z02 = settings.getBoolean("codesmith.adventskalender:id/z02", false);
        Boolean z03 = settings.getBoolean("codesmith.adventskalender:id/z03", false);
        Boolean z04 = settings.getBoolean("codesmith.adventskalender:id/z04", false);
        Boolean z05 = settings.getBoolean("codesmith.adventskalender:id/z05", false);
        Boolean z06 = settings.getBoolean("codesmith.adventskalender:id/z06", false);
        Boolean z07 = settings.getBoolean("codesmith.adventskalender:id/z07", false);
        Boolean z08 = settings.getBoolean("codesmith.adventskalender:id/z08", false);
        Boolean z09 = settings.getBoolean("codesmith.adventskalender:id/z09", false);
        Boolean z10 = settings.getBoolean("codesmith.adventskalender:id/z10", false);
        Boolean z11 = settings.getBoolean("codesmith.adventskalender:id/z11", false);
        Boolean z12 = settings.getBoolean("codesmith.adventskalender:id/z12", false);
        Boolean z13 = settings.getBoolean("codesmith.adventskalender:id/z13", false);
        Boolean z14 = settings.getBoolean("codesmith.adventskalender:id/z14", false);
        Boolean z15 = settings.getBoolean("codesmith.adventskalender:id/z15", false);
        Boolean z16 = settings.getBoolean("codesmith.adventskalender:id/z16", false);
        Boolean z17 = settings.getBoolean("codesmith.adventskalender:id/z17", false);
        Boolean z18 = settings.getBoolean("codesmith.adventskalender:id/z18", false);
        Boolean z19 = settings.getBoolean("codesmith.adventskalender:id/z19", false);
        Boolean z20 = settings.getBoolean("codesmith.adventskalender:id/z20", false);
        Boolean z21 = settings.getBoolean("codesmith.adventskalender:id/z21", false);
        Boolean z22 = settings.getBoolean("codesmith.adventskalender:id/z22", false);
        Boolean z23 = settings.getBoolean("codesmith.adventskalender:id/z23", false);
        Boolean z24 = settings.getBoolean("codesmith.adventskalender:id/z24", false);

        if (z01 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z01);
            bildzuordnung(b);
        }
        if (z02 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z02);
            bildzuordnung(b);
        }
        if (z03 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z03);
            bildzuordnung(b);
        }
        if (z04 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z04);
            bildzuordnung(b);
        }
        if (z05 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z05);
            bildzuordnung(b);
        }
        if (z06 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z06);
            bildzuordnung(b);
        }
        if (z07 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z07);
            bildzuordnung(b);
        }
        if (z08 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z08);
            bildzuordnung(b);
        }
        if (z09 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z09);
            bildzuordnung(b);
        }
        if (z10 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z10);
            bildzuordnung(b);
        }
        if (z11 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z11);
            bildzuordnung(b);
        }
        if (z12 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z12);
            bildzuordnung(b);
        }
        if (z13 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z13);
            bildzuordnung(b);
        }
        if (z14 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z14);
            bildzuordnung(b);
        }
        if (z15 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z15);
            bildzuordnung(b);
        }
        if (z16 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z16);
            bildzuordnung(b);
        }
        if (z17 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z17);
            bildzuordnung(b);
        }
        if (z18 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z18);
            bildzuordnung(b);
        }
        if (z19 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z19);
            bildzuordnung(b);
        }
        if (z20 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z20);
            bildzuordnung(b);
        }
        if (z21 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z21);
            bildzuordnung(b);
        }
        if (z22 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z22);
            bildzuordnung(b);
        }
        if (z23 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z23);
            bildzuordnung(b);
        }
        if (z24 == true) {
            ImageButton b = (ImageButton) findViewById(R.id.z24);
            bildzuordnung(b);
        }


        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd");
        String today = df.format(c.getTime());
        Integer todayAsInt = Integer.parseInt(today);

        if (todayAsInt > 0 && todayAsInt < 25) {
            final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
            animation.setDuration(1000); // duration - half a second
            animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
            animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
            animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in

            int todayButtonId = getResources().getIdentifier("z" + today, "id", getPackageName());
            String stemp = "codesmith.adventskalender2016:id/z" + today;
            Boolean z25 = settings.getBoolean(stemp, false);
            if (z25 == false) {
                ImageButton ib = (ImageButton) findViewById(todayButtonId);
                ib.startAnimation(animation);
            }
        }
        //ask User for Username if not setted yet.
        if (isUserNameSet()) {
            setUserName();
        }

    }

    public void bildzuordnung(ImageButton b) {
        switch (b.getId()) {
            case R.id.z01:
                b.setImageResource(R.drawable.bild_13);
                break;
            case R.id.z02:
                b.setImageResource(R.drawable.bild_02);
                break;
            case R.id.z03:
                b.setImageResource(R.drawable.bild_20);
                break;
            case R.id.z04:
                b.setImageResource(R.drawable.bild_08);
                break;
            case R.id.z05:
                b.setImageResource(R.drawable.bild_12);
                break;
            case R.id.z06:
                b.setImageResource(R.drawable.bild_21);
                break;
            case R.id.z07:
                b.setImageResource(R.drawable.bild_04);
                break;
            case R.id.z08:
                b.setImageResource(R.drawable.bild_16);
                break;
            case R.id.z09:
                b.setImageResource(R.drawable.bild_22);
                break;
            case R.id.z10:
                b.setImageResource(R.drawable.bild_01);
                break;
            case R.id.z11:
                b.setImageResource(R.drawable.bild_05);
                break;
            case R.id.z12:
                b.setImageResource(R.drawable.bild_17);
                break;
            case R.id.z13:
                b.setImageResource(R.drawable.bild_11);
                break;
            case R.id.z14:
                b.setImageResource(R.drawable.bild_23);
                break;
            case R.id.z15:
                b.setImageResource(R.drawable.bild_03);
                break;
            case R.id.z16:
                b.setImageResource(R.drawable.bild_14);
                break;
            case R.id.z17:
                b.setImageResource(R.drawable.bild_19);
                break;
            case R.id.z18:
                b.setImageResource(R.drawable.bild_06);
                break;
            case R.id.z19:
                b.setImageResource(R.drawable.bild_15);
                break;
            case R.id.z20:
                b.setImageResource(R.drawable.bild_07);
                break;
            case R.id.z21:
                b.setImageResource(R.drawable.bild_18);
                break;
            case R.id.z22:
                b.setImageResource(R.drawable.bild_24);
                break;
            case R.id.z23:
                b.setImageResource(R.drawable.bild_09);
                break;
            case R.id.z24:
                b.setImageResource(R.drawable.bild_10);
                break;
        }
    }


    public void klick(View v) {
        Intent intent = new Intent(this, Frage.class);
        Bundle bund = new Bundle();
        v.clearAnimation();
        String idAsString = v.getResources().getResourceName(v.getId());
        String substring = idAsString.substring(Math.max(idAsString.length() - 2, 0)); //Zahl fuer den Titel aus dem Id Namen
        bund.putString("idAsString", idAsString);
        bund.putInt("id", v.getId());
        intent.putExtras(bund);

        if (checkDate(substring)) {
            FrageSuspendsMusic = true;
            startActivityForResult(intent, 1); // 1 ist der Request Code? So wird OnActivityResult aufgerufen, wenn die Activity wieder geschlossen wird.
        } else {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.f_wrong);
            mp.start();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            TextView msg = new TextView(this);
            msg.setText("Zu früh...");
            msg.setPadding(10, 15, 10, 10);
            msg.setTextSize(20);
            msg.setGravity(Gravity.CENTER);
            builder.setView(msg);
            builder.setPositiveButton("Zurück zum Kalender", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }


    public Boolean checkDate(String day) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String valid_until = day + "/12/" + getString(R.string.release_year);
        Date strDate = null;
        try {
            strDate = sdf.parse(valid_until);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (new Date().after(strDate)) {
            return true;
        }
        return false;
    }


    public boolean isUserNameSet() {
        String mpf = getResources().getString(R.string.MyPrefsFile);
        SharedPreferences settings = getSharedPreferences(mpf, 0);
        return settings.getString(getResources().getString(R.string.res_user_name), "no_user_name_yet").equals("no_user_name_yet");
    }


    public void setUserName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        String mpf = getResources().getString(R.string.MyPrefsFile);
        final SharedPreferences settings = getSharedPreferences(mpf, 0);
        if (isUserNameSet()) {
            builder.setTitle("Wie heißt du?");
        } else {
            String userName = settings.getString(getResources().getString(R.string.res_user_name), "Niemand");
            builder.setTitle("Aktueller Name: \"" + userName + "\"");
        }

        // Set up the input
        final EditText input = new EditText(this);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String userName = input.getText().toString();
                if (userName.length() == 0) {
                    toast("Name nicht geändert");
                    return;
                }

                SharedPreferences.Editor editor = settings.edit();
                editor.putString(getResources().getString(R.string.res_user_name), userName);
                editor.apply();
                toast("Viel Spaß " + userName);
            }
        });

        builder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                toast("Name nicht geändert");
            }
        });

        builder.show();


    }

    void toast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(this, "Viel Spaß " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.change_user_name:
                setUserName();
                return true;
            case R.id.overall_stats:
                StatisticSView statisic_view = new StatisticSView(this);
                try {
                    statisic_view.postOverallData();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onCreate(new Bundle()); //refresht wenn Frage gefinished wird, da OnCreate bei Finish nicht ausgeloest wird...
    }

    @Override
    public void onBackPressed() {
        if (AudioPlay.isplayingAudio) {
            AudioPlay.stopAudio();
        }
        MainActivity.this.finish();
    }

    @Override
    protected void onPause() {
        // music wird gestoppt, wenn im standby. wird nicht gestopped, wenn die frage gesatartet wird
        if (AudioPlay.isplayingAudio && FrageSuspendsMusic == false) {
            AudioPlay.stopAudio();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        // only when screen turns on
        if (!AudioPlay.isplayingAudio) {
            AudioPlay.playAudio(this, R.raw.winterbells);
        }
        super.onResume();
    }

}
