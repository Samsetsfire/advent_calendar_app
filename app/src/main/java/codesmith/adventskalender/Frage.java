package codesmith.adventskalender;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;


import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Frage extends Activity {
    List<String> antwortDesTages = new ArrayList<String>();
    String lsg = "Richtig!";
    int false_answere_counter = 0;
    String idAsString;
    String day_as_string;
    LocalResult result;
    StatisticSView statisic_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frage);
        Bundle bund = getIntent().getExtras(); //erstellt ein Bundle um die Uebergabeparameter aus der Mainactivity auslesen zu koennen
        this.idAsString = bund.getString("idAsString"); //Holt den ID Namen aus Uebergabeparameter
        this.day_as_string = idAsString.substring(Math.max(idAsString.length() - 2, 0));
        this.statisic_view= new StatisticSView(this);
        this.result = new LocalResult(this, day_as_string);
        Integer id = bund.getInt("id"); // Holt die ID des Tagesbutton aus den Uebergabeparameter
        String substring = idAsString.substring(Math.max(idAsString.length() - 2, 0)); //Zahl fuer den Titel aus dem Id Namen
        setTitle(substring + ". Dezember"); // Titel der Aktivity
        //Loesungen kleinschreiben, da tolower
        //Laenge der Loesungen moeglichst gleich halten, damit die Laengen-Hinweise bei falschen Antworten passen?


        switch (id) {

            //region Familie

            case R.id.z01:
                antwortDesTages.add("Tesla".toLowerCase());
                createQuestionElement("Welche Automarke ist gesucht?", R.drawable.f01);
                break;
            case R.id.z02:
                antwortDesTages.add("WWK Arena".toLowerCase());
                createQuestionElement("Wie heißt das Stadion des FCA?", R.drawable.f02);
                break;
            case R.id.z03:
                antwortDesTages.add("Fridays for Future".toLowerCase());
                createQuestionElement("\"Fredagar för framtiden\"\nWas könnte das heißen?", R.drawable.f03);
                break;
            case R.id.z04:
                antwortDesTages.add("New England Patriots".toLowerCase());
                createQuestionElement("Zu wem gehört dieses Logo?", R.drawable.f04);
                break;
            case R.id.z05:
                antwortDesTages.add("Simpsons".toLowerCase());
                createQuestionElement("Aus welcher Serie ist dieses Haus?", R.drawable.f05);
                break;
            case R.id.z06:
                antwortDesTages.add("Otter".toLowerCase());
                createQuestionElement("Von welchem Tier stammt diese Spur?", R.drawable.f06);
                break;
            case R.id.z07:
                antwortDesTages.add("Hongkong".toLowerCase());
                createQuestionElement("Wessen Flagge ist das?", R.drawable.f07);
                break;
            case R.id.z08:
                antwortDesTages.add("Salzburg".toLowerCase());
                createQuestionElement("Welche Stadt ist das?", R.drawable.f08);
                break;
            case R.id.z09:
                antwortDesTages.add("Munch".toLowerCase());
                createQuestionElement("Von wem ist diese Bild", R.drawable.f09);
                break;
            case R.id.z10:
                antwortDesTages.add("Katarakt".toLowerCase());
                createQuestionElement("Kajak: Eine im Wildwasser durch Blöcke oder Felsriegel gegliederte Stromschnelle bezeichnet man als ...", R.drawable.f10);
                break;
            case R.id.z11:
                antwortDesTages.add("Interstellar".toLowerCase());
                createQuestionElement("Aus welchem Film ist diese Szene nachgespielt?", R.raw.f11);
                break;
            case R.id.z12:
                antwortDesTages.add("Kirsch".toLowerCase());
                createQuestionElement("Aus welchem Holz ist dieses Brett?", R.drawable.f12);
                break;
            case R.id.z13:
                antwortDesTages.add("Las Vegas".toLowerCase());
                createQuestionElement("Wo steht dieser Turm?", R.drawable.f13);
                break;
            case R.id.z14:
                antwortDesTages.add("11".toLowerCase());
                createQuestionElement("\"1011\" Welche Dezimalzahl ist gesucht?", R.drawable.f14);
                break;
            case R.id.z15:
                antwortDesTages.add("Bad".toLowerCase());
                createQuestionElement("Was sollte man regelmäßig Putzen?", R.drawable.f15);
                break;
            case R.id.z16:
                antwortDesTages.add("Murmeltier".toLowerCase());
                createQuestionElement("Zu welchem Tier gehört dieser Schädel?", R.drawable.f16);
                break;
            case R.id.z17:
                antwortDesTages.add("Wollen".toLowerCase());
                createQuestionElement("Magie = Physik / ...", R.raw.f17);
                break;
            case R.id.z18:
                antwortDesTages.add("New Mexico".toLowerCase());
                createQuestionElement("Wie heißt der Bundesstaat?", R.drawable.f18);
                break;
            case R.id.z19:
                antwortDesTages.add("Kroatien".toLowerCase());
                createQuestionElement("Aus welchem Land stammen diese Scheine?", R.drawable.f19);
                break;
            case R.id.z20:
                antwortDesTages.add("Relaxo".toLowerCase());
                createQuestionElement("Welches Pokemon ist gesucht?", R.drawable.f20);
                break;
            case R.id.z21:
                antwortDesTages.add("Meran".toLowerCase());
                createQuestionElement("Zu welcher Stadt gehört dieses Wappen?", R.drawable.f21);
                break;
            case R.id.z22:
                antwortDesTages.add("Cummulus".toLowerCase());
                createQuestionElement("Wie bezeichnet man diese Wolken?", R.drawable.f22);
                break;
            case R.id.z23:
                antwortDesTages.add("Minecraft".toLowerCase());
                createQuestionElement("Wie heißt das gesuchte Spiel?", R.drawable.f23);
                break;
            case R.id.z24:
                antwortDesTages.add("Feuerlöscher".toLowerCase());
                createQuestionElement("Was benötigt man heute dringend in Reichweite?", R.raw.f24);
                lsg = "Frohe Weihnachten!";
                break;

            //endregion

        }
    }

    public void createQuestionElement( String question, int res_id) {
//        Es wird nur unterschieden, ob Bild oder Video. Fuer Musik braucht man einen weiteren
//        Parameter wenn man dazu noch ein Bild anzeigen moechte
//        while (AudioPlay.isplayingAudio) {
//            AudioPlay.stopAudio();
//        }
//        AudioPlay.playAudio(this, R.raw.f02);
//
        TextView frage = findViewById(R.id.Frage);
        frage.setText(question);

        Resources resources = getResources();
        if (resources.getResourceTypeName(res_id).equals("drawable")) {
            ImageView bild = findViewById(R.id.Bild);
            bild.setImageResource(res_id);
            bild.setVisibility(View.VISIBLE);
        } else if (resources.getResourceTypeName(res_id).equals("raw")) {
            while (AudioPlay.isplayingAudio) {
                AudioPlay.stopAudio();
            }
            VideoView video = findViewById(R.id.Video);
            Uri uri = Uri.parse(
                    "android.resource://"
                            + getPackageName()
                            + "/"
                            + res_id
            );
            video.setVideoURI(uri);
            video.setVisibility(View.VISIBLE);
            video.start();

            video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }

    public void readAnswere(View v) {


        EditText antwort = findViewById(R.id.Antwort);
        String antwort_benutzer = antwort.getText().toString().toLowerCase(); // Antwortstring wird eingelesen und kleingeschrieben


        //if (message.equals(antwortDesTages)){
        if (antwortDesTages.contains(antwort_benutzer)) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.f_right);
            mp.start();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            TextView msg = new TextView(this);
            msg.setText(lsg);
            msg.setPadding(10, 15, 10, 10);
            msg.setTextSize(20);
            msg.setGravity(Gravity.CENTER);
            builder.setView(msg);
            builder.setPositiveButton("Zurück zum Kalender", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                    //ohne Finisch geht es einfach zurueck zur Frage
                    /* So koennte man was zurueckgeben
                    Intent intent = getIntent();
                    intent.putExtra("key", value);
                    setResult(RESULT_OK, intent);
                    finish();
                    */
                }
            });
            builder.setNegativeButton("Statisitk", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    try {
                        statisic_view.postData(result);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

            //Saves that question is solved
            String mpf = getResources().getString(R.string.MyPrefsFile);        //Eindeutiger String aus string.xml fuer die Shared Preferences
            SharedPreferences settings = getSharedPreferences(mpf, 0);      //Zugriff auf SharedPreferences welche Werte Fest auf der Festpaltte speichert.
            Integer trials = settings.getInt(getResources().getString(R.string.res_trials, day_as_string), 0);
            trials++;

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.GERMAN);
            Date date = new Date(System.currentTimeMillis());
            result.updateResultElement(trials, formatter.format(date));

            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean(idAsString, true);         //Speichert ob der Tag geloesst worden ist.
            editor.apply();

            //Send data to server
            try {
                statisic_view.postDataSilentfinal(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        //Wenn die Antwort nicht im Dictionary zu finden ist:
        else {
            String mpf = getResources().getString(R.string.MyPrefsFile);        //Eindeutiger String aus string.xml fuer die Shared Preferences
            SharedPreferences settings = getSharedPreferences(mpf, 0);      //Zugriff auf SharedPreferences welche Werte Fest auf der Festpaltte speichert.
            Integer trials = settings.getInt(getResources().getString(R.string.res_trials, day_as_string), 0);
            trials++;
            result.updateResultElement(trials);

            false_answere_counter++; // Integer.toString(false_answere_counter;
            String hint = "Leider nicht richtig... ";
            MediaPlayer mp = MediaPlayer.create(this, R.raw.f_wrong);
            mp.start();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            TextView msg = new TextView(this);
            //Diverse String Ueberpruefungen
            // 29.10.2019 Score is only calculated for first Answere... could be improved
            for (String loesung : antwortDesTages) {
                //Berechnung ob ein Buchstabe vertauscht ist
                int score = 0;
                int max_score = 0;
                if (loesung.length() > antwort_benutzer.length()) {
                    max_score = antwort_benutzer.length();
                } else {
                    max_score = loesung.length();
                }
                for (int i = 0; i < max_score; i++) {
                    if (loesung.charAt(i) == antwort_benutzer.charAt(i)) {
                        score++;
                    }
                }
                System.out.println(score);
                if (score - loesung.length() >= -1 && loesung.length() == antwort_benutzer.length()) {
                    hint += " Aber da scheint nur noch ein Buchstabe verdreht.";
                    break; //falls mehrere Loesungen passen
                } else if (loesung.length() - antwort_benutzer.length() < -1) {
                    hint = hint + " Deine Antwort ist zu lang.";
                    break;
                } else if (loesung.length() - antwort_benutzer.length() > 2) {
                    hint = hint + " Deine Antwort ist zu kurz.";
                    break;
                } else if (loesung.contains(antwort_benutzer)) {
                    hint = hint + " Aber schon nah dran!";
                    break;
                }
            }
            msg.setText(hint);
            msg.setPadding(10, 15, 10, 10);
            msg.setTextSize(20);
            msg.setGravity(Gravity.CENTER);
            builder.setView(msg);
            builder.setPositiveButton("Erneut probieren", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_frage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.get_stats:
                try {
                    statisic_view.postData(result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Anfrage mit Datum -> Eintrag wird angelegt
                // Anfrage ohne Datum -> Nur Ergebnisse
                //besser zweite rest funktion -> zum abspeichern und eintragen von Werten
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


//    Loesen Fehler aus, wenn Video abgespielt wird... Null Pointer bei onResume...
//    @Override
//    protected void onPause() {
//        // when the screen is about to turn off und leider auch wenn gedreht wird
//        if (AudioPlay.isplayingAudio) {
//            AudioPlay.pauseAudio();
//        }
//        super.onPause();
//    }
//
//    @Override
//    protected void onResume() {
//        // geht weiter wenn bildschirm nur gedreht wird
//        if (!AudioPlay.isplayingAudio) {
//            AudioPlay.resumeAudio();
//        }
//        super.onResume();
//    }
}
