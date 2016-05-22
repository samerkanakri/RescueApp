package com.sam.amman.rescue.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;

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

    public void setpassword(String p) {
        editor.putString("password", p);
        editor.commit();
    }

    public String getpassword() {
        return sharedPreferences.getString("password", "empty");
    }

    public void setUID_OfCase(int uid) {
        editor.putInt("UID_OfCase", uid);
        editor.commit();
    }

    public int getUID_OfCase() {
        return sharedPreferences.getInt("UID_OfCase", -1);
    }

}
