package com.sam.amman.rescue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sam.amman.rescue.Actors.User;
import com.sam.amman.rescue.Adapters.DataBaseHandler;
import com.sam.amman.rescue.Normal.NavigationMain;

import java.util.List;

public class LoginActivity extends Activity {


    DataBaseHandler db;
    EditText usernameTxt,passwordTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTxt = (EditText)findViewById(R.id.EdTxtUsername);
        passwordTxt = (EditText)findViewById(R.id.EdTxtPassword);


        ((Button)findViewById(R.id.BtnLogin)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DataBaseHandler db = new DataBaseHandler(getApplication());
                User u = new User();
//                u = db.getUser(1);
//                usernameTxt.setText(u.getEmail());
//                passwordTxt.setText(u.getPassword());

                if (db.IsUser(usernameTxt.getText().toString(),passwordTxt.getText().toString())) {
                    Intent intent = new Intent();
                    intent.setClass(getApplication(), NavigationMain.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplication(), "wrong username or password", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent();
//                    intent.setClass(getApplication(), NavigationMainDoctor.class);
//                    startActivity(intent);
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
