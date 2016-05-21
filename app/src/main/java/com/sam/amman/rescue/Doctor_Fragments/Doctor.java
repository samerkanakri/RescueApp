package com.sam.amman.rescue.Doctor_Fragments;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.amman.rescue.Actors.User;
import com.sam.amman.rescue.Adapters.ServiceHandler;
import com.sam.amman.rescue.Adapters.Doctor_CaseListFrag;
import com.sam.amman.rescue.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Doctor extends Fragment {

    View v;
    final String url = "http://rescueproject2016.netne.net/myPHP/readDataAsJSON.php";
    String StrJson;
    ServiceHandler serviceHandler;
    ArrayList<String> usersLst,dataSource;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_doctor,container,false);

        String datasource1[] = {"Case 1","Case 2","Case 3"};

        getCases getCases = new getCases();
        getCases.execute();
        return v;

    }

    class getCases extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            serviceHandler = new ServiceHandler();
            StrJson = serviceHandler.makeServiceCall(url,1);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (StrJson != null) {
                try {
                    JSONObject jsonObj = new JSONObject(StrJson);
                    JSONArray jsonArray ;

//
                    // Getting JSON Array node
                    jsonArray = jsonObj.getJSONArray("data");


//                    ArrayList<User> usersLst = new ArrayList<User>();
                    usersLst = new ArrayList<>();

                    User user = new User();
                    // looping through All Contacts
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject c = jsonArray.getJSONObject(i);


                        user.setEmail(c.getString("Email"));
                        user.setPassword(c.getString("Password"));

                        usersLst.add(i,user.toString());

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            dataSource = usersLst;
            Doctor_CaseListFrag a = new Doctor_CaseListFrag();
            a.setDatasource(usersLst);
            FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.CaseContainer,a);
            tr.commit();

        }
    }
}
