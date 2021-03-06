package com.sam.amman.rescue.Doctor_Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sam.amman.rescue.Adapters.ServiceHandler;
import com.sam.amman.rescue.R;

import java.util.ArrayList;

public class ViewCase extends AppCompatActivity {

    View v;
    final String url = "http://rescueproject2016.netne.net/myPHP/getSymptoms.php";
    String response;
    ServiceHandler serviceHandler;
    ArrayList<String> usersLst;
    int cid;
    TextView symptoms;
    Button respondeBtn , rejectBtn ;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_view_case);
        symptoms = (TextView) findViewById(R.id.namettt);


        respondeBtn = (Button) findViewById(R.id.respondeBtnn);
        rejectBtn = (Button) findViewById(R.id.rejectBtn);

        context=this;
        //get CID from prev activity
        Intent i = getIntent();
        cid = i.getIntExtra("CID",-1);

        LoadCase loadCase = new LoadCase();

        if(cid<1){
            this.finish();
        }else{
            loadCase.execute();
        }

        respondeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("sending requist "," caseResponde");
                startActivity(new Intent(context, CaseResponde.class));
            }
        });

    }

    public void respondToCase(View view){
        Log.e("sending requist "," caseResponde");
        startActivity(new Intent(context, CaseResponde.class));
    }


    public void rejectCase(View view){
        Toast.makeText(context, "this item will be deleted from the list", Toast.LENGTH_SHORT).show();
        ViewCase.this.finish();
    }

    class LoadCase extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            serviceHandler = new ServiceHandler();
            response = serviceHandler.getSymptoms(url,(cid+""));

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            User user = new User();
//
//            if (response != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject(response);
//                    JSONArray jsonArray ;
//
////
//                    // Getting JSON Array node
//                    jsonArray = jsonObj.getJSONArray("data");
//
//
////                    ArrayList<User> usersLst = new ArrayList<User>();
//                    usersLst = new ArrayList<>();
//
//
//                    // looping through All Contacts
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject c = jsonArray.getJSONObject(i);
//
//                        String StrCid = cid+"";
//                        if(StrCid.equals(c.getString("UID").trim())){
//                            Toast.makeText(getApplication(),"found",Toast.LENGTH_SHORT).show();
//                            user.setEmail(c.getString("Email"));
//                            user.setPassword(c.getString("Password"));
//                            break;
//                        }
//
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                Log.e("ServiceHandler", "Couldn't get any data from the url");
//            }

            response=response.trim();
            symptoms.setText(response.toString());




        }
    }
}
