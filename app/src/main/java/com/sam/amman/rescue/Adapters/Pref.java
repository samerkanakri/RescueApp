package com.sam.amman.rescue.Adapters;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by SAM on 5/8/2016.
 */
public class Pref {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Context context;

    public Pref(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getPackageName(), context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }


    public void setRememberMe(boolean remmeber) {
        editor.putBoolean("remember", remmeber);

    }

    public boolean getRemmeber() {
        return sharedPreferences.getBoolean("remember", false);
    }

    public void setEmail(String email) {
        editor.putString("email", email);

    }

    public String getEmail() {
        return sharedPreferences.getString("email", "");
    }

    public void setpassword(String password) {
        editor.putString("password", password);

    }

    public String getpassword() {
        return sharedPreferences.getString("password", "");
    }


}
