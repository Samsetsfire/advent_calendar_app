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
        this.statisic_view= new StatisticSView(this, day_as_string);
        this.result = new LocalResult(this, day_as_string);
        Integer id = bund.getInt("id"); // Holt die ID des Tagesbutton aus den Uebergabeparameter
        String substring = idAsString.substring(Math.max(idAsString.length() - 2, 0)); //Zahl fuer den Titel aus dem Id Namen
        setTitle(substring + ". Dezember"); // Titel der Aktivity
        //Loesungen kleinschreiben, da tolower
        //Laenge der Loesungen moeglichst gleich halten, damit die Laengen-Hinweise bei falschen Antworten passen?


        switch (id) {

            //region Steffi
//            case R.id.z01:
//                antwortDesTages.add("Schneemann".toLowerCase());
//                createQuestionElement(id, "Im Winter steht er still und stumm\n" +
//                        "dort draußen ganz in weiß herum.", R.raw.s01);
//                break;
//            case R.id.z02:
//                antwortDesTages.add("Fenster".toLowerCase());
//                createQuestionElement(id, "Ich bringe die Sonne nach Heim,\n" +
//                        "aber ich muss völlig sauber sein.\n" +
//                        "Die Leute mögen mich einbauen,\n" +
//                        "durch die Wand zuzuschauen.", R.raw.s02);
//                break;
//            case R.id.z03:
//                antwortDesTages.add("Nuss".toLowerCase());
//                createQuestionElement(id, "Harte Schale, leckerer Kern,\n" +
//                        "wer mich knackt, der isst mich gern?", R.raw.s03);
//                break;
//            case R.id.z04:
//                antwortDesTages.add("Atem".toLowerCase());
//                createQuestionElement(id, "Er ist leichter als die Feder,\n" +
//                        "aber weder der stärkste Mann\n" +
//                        "kann ihn nicht mehr\n" +
//                        "als drei Minuten halten.", R.drawable.s04);
//                break;
//            case R.id.z05:
//                antwortDesTages.add("Ampel".toLowerCase());
//                createQuestionElement(id, "Ich habe drei verschiedene Augen,\n" +
//                        "und trotzdem kann nichts sehen.\n" +
//                        "Und zu Fahrern und Spaziergängern\n" +
//                        "sage ich wann zu halten oder wann zu gehen.", R.raw.s05);
//                break;
//            case R.id.z06:
//                antwortDesTages.add("Wintermantel".toLowerCase());
//                createQuestionElement(id, "Im Winter halt' ich dich schön warm,\n" +
//                        "im Frühling nimmst du mich auf 'n Arm.\n" +
//                        "Im Sommer willst du von mir nichts wissen,\n" +
//                        "im Herbst wirst du mich anzieh'n müssen.", R.raw.s06);
//                break;
//            case R.id.z07:
//                antwortDesTages.add("Zebra".toLowerCase());
//                createQuestionElement(id, "In der Wildnis bin ich so schüchtern,\n" +
//                        "und komme nie jemandem in den Weg.\n" +
//                        "Aber in der Stadt, für die Spaziergänger Besten,\n" +
//                        "auf der Straße liegen machen mir kein Schreck.", R.raw.s07);
//                break;
//            case R.id.z08:
//                antwortDesTages.add("Schneeflocke".toLowerCase());
//                createQuestionElement(id, "Hat ein weißes Röckchen an,\n" +
//                        "freut sich dass es fliegen kann.\n" +
//                        "Fängst du es mit den Händen ein,\n" +
//                        "wird es bald geschmolzen sein.", R.raw.s08);
//                break;
//            case R.id.z09:
//                antwortDesTages.add("Ei".toLowerCase());
//                createQuestionElement(id, "Wenn man mich behalten will,\n" +
//                        "muss man mich sorgsam schützen.\n" +
//                        "Aber ohne mich zu brechen,\n" +
//                        "kann man mich nicht benutzen.", R.raw.s09);
//                break;
//            case R.id.z10:
//                antwortDesTages.add("Pilz".toLowerCase());
//                createQuestionElement(id, "Es ist einen Hut im Wald ohne Kopf,\n" +
//                        "mit einem Bein, darauf zu stehen.\n" +
//                        "Aber das Bein hat keinen Schuh\n" +
//                        "und kann nirgendwo nie gehen.", R.raw.s10);
//                break;
//            case R.id.z11:
//                antwortDesTages.add("Spiegel".toLowerCase());
//                createQuestionElement(id, "Ich zeige dir, was du mir zeigst,\n" +
//                        "und wenn du lächelst, lächle ich zurück.\n" +
//                        "Wenn du düster bist, bin ich dasselbe\n" +
//                        "aber mein Rechts ist immer dein Links.", R.drawable.s11);
//                break;
//            case R.id.z12:
//                antwortDesTages.add("Schnecke".toLowerCase());
//                createQuestionElement(id, "Ich bin nicht groß, ich bin wirklich klein.\n" +
//                        "Obwohl ich auch nicht viele Stärke habe,\n" +
//                        "muss ich mein Haus auf dem Rücken tragen!\n" +
//                        "Kann man jetzt meinen Namen sagen?\n", R.raw.s12);
//                break;
//            case R.id.z13:
//                antwortDesTages.add("Schildkröte".toLowerCase());
//                createQuestionElement(id, "Sie schwimmt in der See,\n" +
//                        "auf dem Boden wandelt sie.\n" +
//                        "Sie verlässt nie ihr Haus,\n" +
//                        "egal, ob sie geht oder schläft.", R.drawable.s13);
//                break;
//            case R.id.z14:
//                antwortDesTages.add("Stuhl".toLowerCase());
//                createQuestionElement(id, "Ich habe 4 starke Füße,\n" +
//                        "die nie laufen, die nur fest bleiben,\n" +
//                        "aber in Anwesenheit von der Maus,\n" +
//                        "manche Menschen mögen auf mich  steigen.", R.drawable.s14);
//                break;
//            case R.id.z15:
//                antwortDesTages.add("Schnee".toLowerCase());
//                createQuestionElement(id, "Manchmal komm' ich über Nacht,\n" +
//                        "fall vom Himmel leis' und sacht.\n" +
//                        "Zäune, Dächer und Kirchturmspitzen\n" +
//                        "bekommen weiße Zipfelmützen.", R.raw.s15);
//                break;
//            case R.id.z16:
//                antwortDesTages.add("Schornstein".toLowerCase());
//                createQuestionElement(id, "Ich sitze auf dem Dach\n" +
//                        "und jeden Tag rauche,\n" +
//                        "doch weder Pfeifen\n" +
//                        "noch Tabak brauche!", R.raw.s16);
//                break;
//            case R.id.z17:
//                antwortDesTages.add("Elefant".toLowerCase());
//                createQuestionElement(id, "Ich bin sehr groß, groß wie ein Haus,\n" +
//                        "habe aber ein wenig Angst vor der Maus.\n" +
//                        "Ich habe große Ohren und dicker Bauch,\n" +
//                        "aber meine Nase ist wie ein Gartenschlauch.", R.raw.s17);
//                break;
//            case R.id.z18:
//                antwortDesTages.add("Wind".toLowerCase());
//                createQuestionElement(id, "Er hat keine Flügel und kann fliegen,\n" +
//                        "er hat keine Hände und kann Dinge heben,\n" +
//                        "er hat keine Beine und kann nicht stehen,\n" +
//                        "Aber er kann sich sehr schnell bewegen.", R.raw.s18);
//                break;
//            case R.id.z19:
//                antwortDesTages.add("Wolke".toLowerCase());
//                createQuestionElement(id, "Fliegt aber hat keine Flügel,\n" +
//                        "weint aber hat keine Augen.\n" +
//                        "Was ist das?", R.raw.s19);
//                break;
//            case R.id.z20:
//                antwortDesTages.add("Schatten".toLowerCase());
//                createQuestionElement(id, "Ich bin schwarz wie die Nacht,\n" +
//                        "Und ich folge dir immer.\n" +
//                        "Nach der Dunkelheit gehe ich hinein,\n" +
//                        "Am Tag komme ich wieder.", R.raw.s20);
//                break;
//            case R.id.z21:
//                antwortDesTages.add("Igel".toLowerCase());
//                createQuestionElement(id, "Ich habe lange Nadeln\n" +
//                        "wie zunähen, ich weiß nicht.\n" +
//                        "Ich gehe aus nur, wenn es Dunkel ist.\n" +
//                        "Weißt Du, wie man meinen Namen spricht?", R.raw.s21);
//                break;
//            case R.id.z22:
//                antwortDesTages.add("Schwamm".toLowerCase());
//                createQuestionElement(id, "Ich bin voller Löcher,\n" +
//                        "aber dennoch halte ich das Wasser.\n" +
//                        "Wer bin ich?", R.drawable.s22);
//                break;
//            case R.id.z23:
//                antwortDesTages.add("Feuer".toLowerCase());
//                createQuestionElement(id, "Gib mir Nahrung und ich lebe,\n" +
//                        "gib mir Wasser und ich sterbe.\n" +
//                        "Was ist das?\n", R.raw.s23);
//                lsg="ALLES GUTE zum GEBURTSTAG !!! <3";
//                break;
//            case R.id.z24:
//                antwortDesTages.add("Tannenbaum".toLowerCase());
//                createQuestionElement(id, "Was grünt im Sommer und im Winter,\n" +
//                        "erfreut zur Weihnachtszeit die Kinder?", R.raw.s24);
//                lsg = "Frohe Weihnachten!";
//                break;
            //endregion

            //region Familie

            case R.id.z01:
                antwortDesTages.add("triceratops".toLowerCase());
                createQuestionElement(id, "Welcher Dinosaurier ist hier gesucht?", R.drawable.f01);
                break;
            case R.id.z02:
                antwortDesTages.add("Charleston".toLowerCase());
                antwortDesTages.add("Boggie Woogie".toLowerCase());
                antwortDesTages.add("Rock N Roll".toLowerCase());
                antwortDesTages.add("rock'n roll".toLowerCase());
                createQuestionElement(id, "Wie nennt man diesen Tanz?", R.raw.f02);
                break;
            case R.id.z03:
                antwortDesTages.add("Pikachu".toLowerCase());
                antwortDesTages.add("Ralph Wiggum".toLowerCase());
                createQuestionElement(id, "Welche Figur ist hier gesucht?", R.drawable.f03);
                break;
            case R.id.z04:
                antwortDesTages.add("Fußballtennis".toLowerCase());
                createQuestionElement(id, "Wie nennt man dieses Sportart?", R.raw.f04);
                break;
            case R.id.z05:
                antwortDesTages.add("Spannung".toLowerCase());
                antwortDesTages.add("elektrische Spannung".toLowerCase());
                createQuestionElement(id, "Was misst man in Volt?", R.drawable.f05);
                break;
            case R.id.z06:
                antwortDesTages.add("Doppelter Henkersknoten".toLowerCase());
                createQuestionElement(id, "Wie nennt man diesen Knoten?", R.raw.f06);
                break;
            case R.id.z07:
                antwortDesTages.add("Albanien".toLowerCase());
                createQuestionElement(id, "Zu welchem Land gehört diese Flagge?", R.drawable.f07);
                break;
            case R.id.z08:
                antwortDesTages.add("Schlagbohrer".toLowerCase());
                createQuestionElement(id, "Welches Gerät wird hier erfunden?", R.raw.f08);
                break;
            case R.id.z09:
                antwortDesTages.add("Angela Merkel".toLowerCase());
                createQuestionElement(id, "Wessen Unterschrift ist das?", R.drawable.f09);
                break;
            case R.id.z10:
                antwortDesTages.add("Erde".toLowerCase());
                antwortDesTages.add("Sand".toLowerCase());
                antwortDesTages.add("Gummi".toLowerCase());
                antwortDesTages.add("".toLowerCase());
                createQuestionElement(id, "Nach was schmecken Regenwürmer?", R.raw.f10);
                lsg = "Ich hoffe du hast mal probiert ;)";
                break;
            case R.id.z11:
                antwortDesTages.add("Amsterdam".toLowerCase());
                createQuestionElement(id, "Welche Stadt ist gesucht?", R.drawable.f11);
                break;
            case R.id.z12:
                antwortDesTages.add("28".toLowerCase());
                antwortDesTages.add("28,8".toLowerCase());
                antwortDesTages.add("28.8".toLowerCase());
                createQuestionElement(id, "Wie viele Meter legt ein Auto in einer Sekunde zurück, wenn es 100 km/h schnell fährt? Die Antwort darf gerundet werden ;)", R.drawable.f12);
                break;
            case R.id.z13:
                antwortDesTages.add("Loop".toLowerCase());
                createQuestionElement(id, "Wie nennt man diesen Trick?", R.raw.f13);
                break;
            case R.id.z14:
                antwortDesTages.add("Queen".toLowerCase());
                createQuestionElement(id, "Finde den gesuchten Songtitel. Wer ist der Interpret?", R.drawable.f14);
                break;
            case R.id.z15:
                antwortDesTages.add("Andreas Hofer".toLowerCase());
                createQuestionElement(id, "Wie heißt diese Person? Tipp: Es handelt sich um einen Tiroler", R.drawable.f15);
                break;
            case R.id.z16:
                antwortDesTages.add("Augmented reality".toLowerCase());
                antwortDesTages.add("Augmented reality App".toLowerCase());
                createQuestionElement(id, "Welcher Fachbegriff der Anwendung ist gesucht?", R.raw.f16);
                break;
            case R.id.z17:
                antwortDesTages.add("Google Chrome".toLowerCase());
                antwortDesTages.add("Chrome".toLowerCase());
                antwortDesTages.add("Chrome Browser".toLowerCase());
                createQuestionElement(id, "Wo kann man diesen Dinosaurier finden?", R.drawable.f17);
                break;
            case R.id.z18:
                antwortDesTages.add("Reflex".toLowerCase());
                createQuestionElement(id, "Ein ... ist eine unwillkürliche, rasche und gleichartige Reaktion eines Organismus auf einen bestimmten Reiz.", R.raw.f18);
                break;
            case R.id.z19:
                antwortDesTages.add("Ultimate Frisbee".toLowerCase());
                antwortDesTages.add("Ultimate".toLowerCase());
                createQuestionElement(id, "Wie nennt man die hier gezeigte Sportart?", R.raw.f19);
                break;
            case R.id.z20:
                antwortDesTages.add("Stephen Hawking".toLowerCase());
                createQuestionElement(id, "Wem gehörte dieser Sprachcomputer?", R.drawable.f20);
                break;
            case R.id.z21:
                antwortDesTages.add("Dunning-Kruger-Effekt".toLowerCase());
                antwortDesTages.add("Dunning Kruger Effekt".toLowerCase());
                createQuestionElement(id, "Als ... wird die systematische fehlerhafte Neigung relativ inkompetenter Menschen bezeichnet, " +
                        "das eigene Wissen und Können zu überschätzen und die Kompetenz anderer zu unterschätzen.", R.drawable.f21);
                break;
            case R.id.z22:
                antwortDesTages.add("Keyless Access ".toLowerCase());
                antwortDesTages.add("Keyless Go".toLowerCase());
                antwortDesTages.add("Keyless Entry".toLowerCase());
                createQuestionElement(id, "Welche Fahrzeug-Technik ermöglicht die gezeigte Funktion? (englisch)", R.raw.f22);
                break;
            case R.id.z23:
                antwortDesTages.add("Schach".toLowerCase());
                createQuestionElement(id, "Welches Spiel ist gesucht?", R.drawable.f23);
                break;
            case R.id.z24:
                antwortDesTages.add("weiß".toLowerCase());
                createQuestionElement(id, "Welche Farbe hatte der Mantel des St.Martin vermutlich wirklich?", R.raw.f24);
                lsg = "Frohe Weihnachten!";
                break;

            //endregion

        }
    }

    public void createQuestionElement(int id, String question, int res_id) {
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
            //Speichert dass Frage geloest
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
            // TODO: 29.10.2019 Score is only calculated for first Answere...
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
