package com.sam.amman.rescue;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.sam.amman.rescue.Actors.User;
import com.sam.amman.rescue.Adapters.Prefs;
import com.sam.amman.rescue.Adapters.ServiceHandler;
import com.sam.amman.rescue.Adapters.UserDBHandler;
import com.sam.amman.rescue.Normal.NavigationMain;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {


    EditText emailTxt,passwordTxt;
    CheckBox remembermeChkBx;
    Context  context;


    String url;
    boolean isuser = false;
    ServiceHandler serviceHandler;
    String StrJson , resPost ;
    String newJson;
    List<NameValuePair> nameValuePair ;
    final String urlGet = "http://rescueproject2016.netne.net/myPHP/readDataAsJSON.php";
    JSONObject jObject;
    final String TAG_UID = "UID";
    final String TAG_EMAIL = "Email";
    final String TAG_PASSWORD = "Password";
    final String TAG_FNAME = "Fname";
    String email , password;
    String myj , result;
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
                    Prefs pref = new Prefs(getApplication());
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
        //UserDBHandler db = new UserDBHandler(getApplication());
        email = emailTxt.getText().toString();
        password = passwordTxt.getText().toString();

        if("".equals(email) || "".equals(password)){
            Toast.makeText(getApplication(), "required fields cannot be empty", Toast.LENGTH_SHORT).show();
        }else{
            if(ValidEmail(email)){
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
                GetJSONData jsonData = new GetJSONData();
                jsonData.execute();
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

        @Override
        protected void onPreExecute() {
            super.onPreExecute();






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

            serviceHandler = new ServiceHandler();

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
//            result = serviceHandler.POSTJSON("http://rescueproject2016.netne.net/myPHP/post.php","samer","");
            url = "http://rescueproject2016.netne.net/myPHP/log_in.php?";
            result = serviceHandler.LoginOnService(url,"user@email.com","password");

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

//            e.setText(StrJson);
//            Toast.makeText(getApplication(),"response",Toast.LENGTH_SHORT).show();
            result = result.trim();
            result = result.substring(0,1);
            Toast.makeText(getApplication(),result,Toast.LENGTH_SHORT).show();
            if(result=="1"){
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
