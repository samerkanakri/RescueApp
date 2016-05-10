package com.sam.amman.rescue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.sam.amman.rescue.Adapters.Prefs;
import com.sam.amman.rescue.Adapters.UserDBHandler;
import com.sam.amman.rescue.Normal.NavigationMain;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {


    EditText emailTxt,passwordTxt;
    CheckBox remembermeChkBx;
    Context  context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailTxt = (EditText)findViewById(R.id.EdTxtEmail);
        passwordTxt = (EditText)findViewById(R.id.EdTxtPassword);
        remembermeChkBx = (CheckBox) findViewById(R.id.remembermeChkBx);

//        /**
//         * get preferences
//         */
//        Prefs pref = new Prefs(this);
//        if(pref.getRemmeber()){
//            Toast.makeText(getApplication(), "i remember you", Toast.LENGTH_SHORT).show();
//        }



        /**
         * set preferences
         */
        remembermeChkBx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    Prefs pref = new Prefs(getApplication());
                    pref.setRememberMe(true);
//                    pref.setEmail(emailTxt.getText().toString());
//                    pref.setpassword(passwordTxt.getText().toString());
                    Toast.makeText(getApplication(), "pref set", Toast.LENGTH_SHORT).show();
                }else{
//                    pref.setRememberMe(false);
//                    Toast.makeText(getApplication(), "pref cleared", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    public void register0(View view){
        Intent intent = new Intent();
        intent.setClass(getApplication(),RegActivity.class);
        startActivity(intent);
//        LoginActivity.this.finish();
    }

    public void Login(View view){
        UserDBHandler db = new UserDBHandler(getApplication());
        String email = emailTxt.getText().toString();
        String password = passwordTxt.getText().toString();
        if(ValidEmail(email)){
            if (db.IsUser(email,password)) {

                // check for Role

                Intent intent = new Intent();
                intent.setClass(getApplication(), NavigationMain.class);
                startActivity(intent);

            } else {
                Toast.makeText(getApplication(), "wrong username or password", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplication(), "invalid email", Toast.LENGTH_SHORT).show();
        }
    }

    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private boolean ValidEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

//    private void checkPref(){
//        //pref = new Pref(LoginActivity.this);
//
//            if (pref!=null && pref.getRemmeber()==true){
//                Intent intent = new Intent();
//                intent.setClass(getApplication(), NavigationMain.class);
//                startActivity(intent);
//            }else{
//
//            }
//
//    }
}
