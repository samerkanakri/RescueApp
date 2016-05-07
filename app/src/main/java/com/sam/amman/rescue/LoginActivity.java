package com.sam.amman.rescue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.sam.amman.rescue.Actors.User;
import com.sam.amman.rescue.Adapters.DataBaseHandler;
import com.sam.amman.rescue.Normal.NavigationMain;

import java.util.List;

public class LoginActivity extends Activity {


    DataBaseHandler db;
    Boolean rememberme = false;
    EditText usernameTxt,passwordTxt;
    CheckBox remembermeChkBx;
    SharedPreferences sharedPref,sharedPrefGet;
    SharedPreferences.Editor PrefEditor;
    Context context;

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTxt = (EditText)findViewById(R.id.EdTxtUsername);
        passwordTxt = (EditText)findViewById(R.id.EdTxtPassword);
        remembermeChkBx = (CheckBox) findViewById(R.id.remembermeChkBx);

        /**
         * get preferences
         */
        {
            sharedPrefGet = this.getPreferences(Context.MODE_PRIVATE);
            String defaultValue = "";
            String usernamePref = sharedPrefGet.getString(getString(R.string.preference_username), defaultValue);

            usernameTxt.setText(usernamePref);
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


        ((Button)findViewById(R.id.BtnLogin)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DataBaseHandler db = new DataBaseHandler(getApplication());
//                    User u = new User();
//                    u = db.getUser(1);
//                    usernameTxt.setText(u.getEmail());
//                    passwordTxt.setText(u.getPassword());

                if (db.IsUser(usernameTxt.getText().toString(),passwordTxt.getText().toString())) {

                    // check for Role

                    Intent intent = new Intent();
                    intent.setClass(getApplication(), NavigationMain.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplication(), "wrong username or password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ((Button)findViewById(R.id.BtnRegister)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent intent = new Intent();
                intent.setClass(getApplication(),RegActivity.class);
                startActivity(intent);
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
}
