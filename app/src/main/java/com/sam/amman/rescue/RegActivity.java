package com.sam.amman.rescue;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sam.amman.rescue.Adapters.ServiceHandler;
import com.sam.amman.rescue.Adapters.Local_UserDB_Handler;

import java.util.regex.Pattern;

public class RegActivity extends AppCompatActivity {


    Local_UserDB_Handler db;
    String response;
    String url;
    Spinner spinner;
    Button reg;
    EditText emailEdt,passwordEdt,passwordConfirm;
    String emailStr ;
    String passwordStr,passwordConfirmStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);


        /**
         * ACTION BAR
         */
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
         * VIEWS
         */
        emailEdt = (EditText) findViewById(R.id.emailReg);
        passwordEdt = (EditText) findViewById(R.id.passwordReg);
        passwordConfirm = (EditText) findViewById(R.id.passwordConfirm);
        reg = (Button) findViewById(R.id.BtnReg);
        db = new Local_UserDB_Handler(this);

        /**
         * registration button
         */
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //saving
            emailStr = emailEdt.getText().toString();
            passwordStr = passwordEdt.getText().toString();
            passwordConfirmStr = passwordConfirm.getText().toString();

            spinner = (Spinner) findViewById(R.id.spinnerCountryCodes);



            if("".equals(emailStr) || "".equals(passwordStr)){
                Toast.makeText(RegActivity.this, "required fields should not be empty", Toast.LENGTH_SHORT).show();
            }else{
                if(ValidEmail(emailStr)){
                    if(passwordConfirmStr.equals(passwordStr)){
                        try {
//                            db = new Local_UserDB_Handler(getApplication());
//                            User user = new User();
//                            user.setEmail(emailStr);
//                            user.setPassword(passwordStr);
//                            db.addUser(user);
//                            db.close();
                            ;
                            //send data to web service in a new thread
                            SendData send = new SendData();
                            send.execute();

                            //Toast.makeText(RegActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Log.w(" --- ", "onClick: ",e );
                            Toast.makeText(RegActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegActivity.this, "password does not match", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegActivity.this, "invalid email", Toast.LENGTH_SHORT).show();
                }
            }
            }
        });



//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.country_codes, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                return true;
        }
        return super.onOptionsItemSelected(item);
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


    class SendData extends AsyncTask<Void, Void, Void>{


        @Override
        protected Void doInBackground(Void... voids) {

            ServiceHandler serviceHandler = new ServiceHandler();

            try {

                //?TODO=login&email="+"user9@email.com"+"&password="+"password9
                url = "http://rescueproject2016.netne.net/myPHP/register.php";
//                response = serviceHandler.POSTJSON("http://rescueproject2016.netne.net/myPHP/post.php","samer","");
                response = serviceHandler.RegisterOnService(url,emailStr,passwordStr);
            }catch (Exception e){
                Toast.makeText(RegActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }


            return null;


        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            response=response.trim();
            //response = response.substring(0,1);
            Toast.makeText(RegActivity.this, response, Toast.LENGTH_SHORT).show();
        }
    };


}
