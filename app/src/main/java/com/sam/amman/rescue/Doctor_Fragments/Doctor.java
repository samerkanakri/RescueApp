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
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sam.amman.rescue.Actors.Case;
import com.sam.amman.rescue.Actors.User;
import com.sam.amman.rescue.Adapters.Preferences;
import com.sam.amman.rescue.Adapters.ServiceHandler;
import com.sam.amman.rescue.Adapters.Doctor_CaseListFrag;
import com.sam.amman.rescue.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Doctor extends Fragment implements View.OnClickListener {

    View v;
    Preferences pref;
    final String url = "http://rescueproject2016.netne.net/myPHP/readCasesAsJSON.php";
    String StrJson;
    ServiceHandler serviceHandler;
    ArrayList<String> usersLst,dataSource;
    Button refresh;
    getCases getCases;
    String status;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_doctor,container,false);

        refresh = (Button) v.findViewById(R.id.refresh);
        String datasource1[] = {"Case 1","Case 2","Case 3"};
        RadioButton radioButton3=(RadioButton) v.findViewById(R.id.radioButton3);
        RadioButton radioButton2=(RadioButton) v.findViewById(R.id.radioButton2);
        RadioButton radioButton=(RadioButton) v.findViewById(R.id.radioButton);

        radioButton.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);

        //TODO set checked
        pref = new Preferences(getActivity());
        if(pref.getStatus().equals("available")){
            radioButton.setChecked(true);
        }
        if(pref.getStatus().equals("away")){
            radioButton.setChecked(true);
        }
        if(pref.getStatus().equals("off")){
            radioButton.setChecked(true);
        }

        refresh.setOnClickListener(this);

        getCases = new getCases();
        getCases.execute();
        return v;




    }


    @Override
    public void onClick(View view) {

        Preferences pref = new Preferences(getActivity());
        if(view.getId()==R.id.radioButton){
            pref.setStatus("available");
        }
        if(view.getId()==R.id.radioButton2){
            pref.setStatus("away");
        }
        if(view.getId()==R.id.radioButton3){
            pref.setStatus("off");
        }
        if(view.getId()==R.id.refresh){
            getCases = new getCases();
            getCases.execute();
        }
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

                    Case _case = new Case();
                    // looping through All Contacts
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject c = jsonArray.getJSONObject(i);

                        int uid = Integer.parseInt(c.getString("UID"));
                        _case.setCID(uid);
                        _case.setTime(c.getString("DateTime"));
                        _case.setLocation(c.getString("Location"));
                        _case.setSetNew(c.getString("isNew"));


                        pref = new Preferences(getActivity());
                        if(_case.getSetNew().equals("1")) {
                            usersLst.add(_case.toString());
                        }


                        // TODO used to load user details
//                        Preferences pref=new Preferences(getActivity());
//                        pref.setUID(c.getString("UID"));

                        //Toast.makeText(getActivity(),"user id " + (uid),Toast.LENGTH_SHORT).show();


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            if(pref.getStatus().equals("available")) {
                dataSource = usersLst;
                Doctor_CaseListFrag a = new Doctor_CaseListFrag();
                a.setDatasource(usersLst);
                FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.CaseContainer, a);
                tr.commit();
            }



        }
    }
}
