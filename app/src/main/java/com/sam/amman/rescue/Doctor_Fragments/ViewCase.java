package com.sam.amman.rescue.Doctor_Fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sam.amman.rescue.Actors.User;
import com.sam.amman.rescue.Adapters.Doctor_CaseListFrag;
import com.sam.amman.rescue.Adapters.ServiceHandler;
import com.sam.amman.rescue.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ViewCase extends AppCompatActivity {

    View v;
    final String url = "http://rescueproject2016.netne.net/myPHP/readDataAsJSON.php";
    String StrJson;
    ServiceHandler serviceHandler;
    ArrayList<String> usersLst;
    int cid;
    TextView name , pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_view_case);
        name = (TextView) findViewById(R.id.namettt);
        pass = (TextView) findViewById(R.id.pass);

        Intent i = getIntent();
        cid = i.getIntExtra("CID",-1);

        LoadCase loadCase = new LoadCase();

        if(cid<1){
            this.finish();
        }else{
            Toast.makeText(this,"Case " + cid + " is loading",Toast.LENGTH_SHORT).show();
            loadCase.execute();
        }
    }

    class LoadCase extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            serviceHandler = new ServiceHandler();
            StrJson = serviceHandler.makeServiceCall(url,1);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            User user = new User();

            if (StrJson != null) {
                try {
                    JSONObject jsonObj = new JSONObject(StrJson);
                    JSONArray jsonArray ;

//
                    // Getting JSON Array node
                    jsonArray = jsonObj.getJSONArray("data");


//                    ArrayList<User> usersLst = new ArrayList<User>();
                    usersLst = new ArrayList<>();


                    // looping through All Contacts
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject c = jsonArray.getJSONObject(i);

                        String StrCid = cid+"";
                        if(StrCid.equals(c.getString("UID").trim())){
                            Toast.makeText(getApplication(),"found",Toast.LENGTH_SHORT).show();
                            user.setEmail(c.getString("Email"));
                            user.setPassword(c.getString("Password"));
                            break;
                        }


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            name.setText(user.getEmail());
            pass.setText(user.getPassword());

            //DISPLAY YOU INFO



        }
    }
}
