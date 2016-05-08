package com.sam.amman.rescue.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;

/**
 * Created by SAM on 5/8/2016.
 */
public class Pref extends PreferenceActivity{


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Context context;

    public Pref(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getPackageName(), context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }


    public final void setRememberMe(boolean remmeber) {

        editor.putBoolean("remember", remmeber);

    }

    public final boolean getRemmeber() {
        return sharedPreferences.getBoolean("remember", false);
    }

    public void setEmail(String e) {
        editor.putString("email", e);
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "empty");
    }

    public void setpassword(String p) {
        editor.putString("password", p);
    }

    public String getpassword() {
        return sharedPreferences.getString("password", "empty");
    }


}
