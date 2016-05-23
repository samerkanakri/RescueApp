package com.sam.amman.rescue;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.sam.amman.rescue.Adapters.Preferences;
import com.sam.amman.rescue.Adapters.ServiceHandler;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {


    EditText emailTxt,passwordTxt;
    CheckBox remembermeChkBx;
    Context  context;

    String url;
    ServiceHandler serviceHandler;
    final String TAG_UID = "UID";
    final String TAG_EMAIL = "Email";
    final String TAG_PASSWORD = "Password";
    final String TAG_FNAME = "Fname";
    String emailtosend , passwordtosend;
    String response;
    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailTxt = (EditText)findViewById(R.id.EdTxtEmail);
        passwordTxt = (EditText)findViewById(R.id.EdTxtPassword);
        remembermeChkBx = (CheckBox) findViewById(R.id.remembermeChkBx);

        /**
         * set preferences
         */
        remembermeChkBx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    Preferences pref = new Preferences(getApplication());
                    pref.setRememberMe(true);
                    Toast.makeText(getApplication(), "preference set", Toast.LENGTH_SHORT).show();
                }else{
//                    pref.setRememberMe(false);
//                    Toast.makeText(getApplication(), "pref cleared", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public void Login(View view){
        //Local_UserDB_Handler db = new Local_UserDB_Handler(getApplication());
        emailtosend = emailTxt.getText().toString();
        passwordtosend = passwordTxt.getText().toString();

        if("".equals(emailtosend) || "".equals(passwordtosend)){
            Toast.makeText(getApplication(), "required fields cannot be empty", Toast.LENGTH_SHORT).show();
        }else{
            if(ValidEmail(emailtosend)){
                // LOCAL
//            if (db.IsUser(email,password)) {
//
//                // check for Role
//
////                Intent intent = new Intent();
////                intent.setClass(getApplication(), NavigationMain.class);
////                startActivity(intent);
//
//            } else {
//                Toast.makeText(getApplication(), "wrong username or password", Toast.LENGTH_SHORT).show();
//            }

                ;
                GetJSONData jsonData = new GetJSONData();
                jsonData.execute();
                ;
//                gotoMain();
                ;
//                if(isuser){
//                    Intent intent = new Intent();
//                    intent.setClass(getApplication(), NavigationMain.class);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(getApplication(), "email does not exist", Toast.LENGTH_SHORT).show();
//                }
            }else{
                Toast.makeText(getApplication(), "invalid email", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private boolean ValidEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    public void register0(View view){
        Intent intent = new Intent();
        intent.setClass(getApplication(),RegActivity.class);
        startActivity(intent);
//        LoginActivity.this.finish();
    }

    class GetJSONData extends AsyncTask<Void,Void,Void> { //on pre  , through , post execute
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
            Toast.makeText(getApplication(), "sending " + emailtosend, Toast.LENGTH_SHORT).show();




        }

        @Override
        protected Void doInBackground(Void... voids) {

//            StrJson = serviceHandler.makeServiceCall(
//                    urlGet,
//                    ServiceHandler.GET);

//            try {
//
//                resPost = serviceHandler.makeServiceCall("http://rescueproject2016.netne.net/myPHP/post.php?"+myj,ServiceHandler.POST,nameValuePair);
//
//
//            }catch (Exception e){
//                Log.w("P O S T ", "doInBackground: ",e );
//            }

            ServiceHandler serviceHandler = new ServiceHandler();
            url = "http://rescueproject2016.netne.net/myPHP/login.php";

            response = serviceHandler.LoginOnService(url,emailtosend,passwordtosend);

//            try {
//                JSONObject newJsonObj = new JSONObject();
//                newJson = "{\"data\":{\"Email\":\"samer.kanakre@email.com\",\"Password\":\"mypassword\"}";
//                newJsonObj.put("Email","samer.kanakre@email.com");
//            }catch (JSONException e){
//                Log.w("J S O N ", "onPreExecute: ",e );
//            }

//            User user = new User();
//            user.setEmail(email);
//            user.setPassword(password);
//            response = serviceHandler.POSTJSON("http://rescueproject2016.netne.net/myPHP/post.php","samer","");


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
//            e.setText(StrJson);
//            Toast.makeText(getApplication(),"response",Toast.LENGTH_SHORT).show();
            response = response.trim();
            Toast.makeText(getApplication(), "recieving "+response,Toast.LENGTH_SHORT).show();
            if(response.equals("1")){
                gotoMain();
            }else{
                Toast.makeText(getApplication(), "email does not exist", Toast.LENGTH_SHORT).show();
            }
//            if (StrJson != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject(StrJson);
//                    JSONArray jsonArray ;
////
//                    // Getting JSON Array node
//                    jsonArray = jsonObj.getJSONArray("data");
//
//                    // looping through All Contacts
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject c = jsonArray.getJSONObject(i);
//
////                        String id = c.getString("UID");
//                        email = c.getString("Email");
//                        password = c.getString("Password");
////                        String fname = c.getString("Fname");
////
////                        c.put(TAG_FNAME, "SUHAIB");
////                        c.put(TAG_EMAIL, "s11ibs@gmail.com");
////                        c.put(TAG_PASSWORD, "555");
//
////                        Toast.makeText(getApplication(),email + " " + password,Toast.LENGTH_SHORT).show();
//
////                        e.setText(email);
////                        p.setText(password);
////                        n.setText(fname);
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                Log.e("ServiceHandler", "Couldn't get any data from the urlGet");
//            }


        }
    }

    public void gotoMain(){
        Intent intent = new Intent();
        intent.setClass(getApplication(), NavigationMain.class);
        startActivity(intent);
    }
}
