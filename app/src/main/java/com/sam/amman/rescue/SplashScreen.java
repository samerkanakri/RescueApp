package com.sam.amman.rescue;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sam.amman.rescue.Adapters.Pref;
import com.sam.amman.rescue.Normal.NavigationMain;

public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH_TIME = 2 * 1000;// 3 seconds

    Pref pref;
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
        pref = new Pref(SplashScreen.this);

        if (pref!=null && pref.getRemmeber()==true){
            Intent intent = new Intent();
            intent.setClass(getApplication(), NavigationMain.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
            startActivity(intent);
            SplashScreen.this.finish();
        }

    }
}
