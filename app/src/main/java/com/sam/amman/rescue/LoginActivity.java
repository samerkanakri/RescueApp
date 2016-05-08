package com.sam.amman.rescue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.sam.amman.rescue.Adapters.DBHandler;
import com.sam.amman.rescue.Adapters.UserDBHandler;
import com.sam.amman.rescue.Normal.NavigationMain;

import java.util.regex.Pattern;

public class LoginActivity extends Activity {


    DBHandler db;
    Boolean rememberme = false;
    EditText emailTxt,passwordTxt;
    CheckBox remembermeChkBx;
    SharedPreferences sharedPref,sharedPrefGet;
    SharedPreferences.Editor PrefEditor;
    Context context;

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailTxt = (EditText)findViewById(R.id.EdTxtEmail);
        passwordTxt = (EditText)findViewById(R.id.EdTxtPassword);
        remembermeChkBx = (CheckBox) findViewById(R.id.remembermeChkBx);

        /**
         * get preferences
         */
        {
            sharedPrefGet = this.getPreferences(Context.MODE_PRIVATE);
            String defaultValue = "";
            String usernamePref = sharedPrefGet.getString(getString(R.string.preference_username), defaultValue);

            //usernameTxt.setText(usernamePref);
        }

        /**
         * save preferences
         */
        remembermeChkBx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(remembermeChkBx.isChecked()){
                    sharedPref = getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(getString(R.string.preference_username), "");
//        editor.putString(getString(R.string.preference_password), "");
                    editor.commit();
                }
                else{
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.clear();
                    editor.commit();
                }
            }
        });


        ((Button)findViewById(R.id.BtnCallDoctor)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //intent.setClass(getApplication(),CallDoctor.class);
                startActivity(intent);
            }
        });
    }

    public void register0(View view){
        Intent intent = new Intent();
        intent.setClass(getApplication(),RegActivity.class);
        startActivity(intent);
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
}
