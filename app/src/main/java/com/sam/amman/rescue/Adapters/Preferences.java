package com.sam.amman.rescue.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;
import android.widget.Toast;

import com.sam.amman.rescue.R;

/**
 * Created by SAM on 5/10/2016.
 */
public class Preferences extends PreferenceActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Context context;



    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        addPreferencesFromResource(R.xml.prefs);

    }

    public Preferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getPackageName(), context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public void setRememberMe(boolean remmeber) {

        editor.putBoolean("remember", remmeber);
        editor.commit();
    }

    public boolean getRemmeber() {

        return sharedPreferences.getBoolean("remember", false);
    }

    public void setEmail(String e) {
        editor.putString("email", e);
        editor.commit();
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "empty");
    }

    public void setUID(String i) {
        editor.putString("uid", i);
        editor.commit();
    }

    public String getUID() {
        return sharedPreferences.getString("uid", "");
    }

    public void setLocation(String l) {
        editor.putString("location", l);
        editor.commit();
    }

    public String getLocation() {
        return sharedPreferences.getString("location", "000");
    }

    public void setRole(String r) {
        editor.putString("role", r);
        editor.commit();
    }

    public String getRole() {
        return sharedPreferences.getString("role", "p");
    }

    public void setStatus(String s) {
        editor.putString("status", s);
        editor.commit();
    }

    public String getStatus() {
        return sharedPreferences.getString("status", "off");
    }

}
