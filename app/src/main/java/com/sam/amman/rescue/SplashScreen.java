package com.sam.amman.rescue;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.Toast;

import com.sam.amman.rescue.Adapters.Prefs;
import com.sam.amman.rescue.Normal.NavigationMain;


public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH_TIME = 2 * 1000;// 3 seconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ShowSplashScreen();

    }

    private void ShowSplashScreen() {
        try {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    checkPref();
                }
            },  SPLASH_TIME);
        } catch(Exception e){}
    }

    private void checkPref(){

        /**
         * get preferences
         */
        Prefs pref = new Prefs(this);
        if(pref.getRemmeber()){
            Toast.makeText(getApplication(), "i remember you", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SplashScreen.this,NavigationMain.class);
            startActivity(intent);
            SplashScreen.this.finish();
        }else {
            Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(intent);
            SplashScreen.this.finish();
        }

    }

}
