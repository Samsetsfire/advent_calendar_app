package codesmith.adventskalender;

import android.content.Context;
import android.content.SharedPreferences;

class Result {
    private Context context;
    private SharedPreferences settings;
    private String day;

    Result(Context current, String day) {
        this.context = current;
        String mpf = context.getResources().getString(R.string.MyPrefsFile);
        this.settings = context.getSharedPreferences(mpf, 0);
        this.day = day;

    }

    void updateResultElement(Integer trials, String solved_date) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(context.getResources().getString(R.string.res_trials, day), trials);
        editor.putString(context.getResources().getString(R.string.res_solved_datetime, day), solved_date);
        editor.apply();

    }

    void updateResultElement(Integer trials) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(context.getResources().getString(R.string.res_trials, day), trials);
        editor.apply();
    }

    Integer get_trials() {
        return settings.getInt(context.getResources().getString(R.string.res_trials, day), 0);
    }

    String get_solved_date() {
        return settings.getString(context.getResources().getString(R.string.res_solved_datetime, day), "");
    }

}
