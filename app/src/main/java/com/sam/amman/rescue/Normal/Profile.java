package com.sam.amman.rescue.Normal;

import android.content.Context;
import android.database.SQLException;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sam.amman.rescue.Actors.User;
import com.sam.amman.rescue.Adapters.DBHandler;
import com.sam.amman.rescue.Adapters.ServiceHandler;
import com.sam.amman.rescue.Adapters.UserDBHandler;
import com.sam.amman.rescue.R;

public class Profile extends Fragment {

    Context context;
    View v;
    Button submit;
    EditText emailTxt,fnameTxt;
    String emailStr,fnameStr,response;
    ServiceHandler serviceHandler;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_profile,container,false);

        emailTxt = (EditText) v.findViewById(R.id.emailEdtxt);
        fnameTxt = (EditText) v.findViewById(R.id.fnameEdtxt);
        submit = (Button) v.findViewById(R.id.BtnSubmit);


        //get current user data
//        try {
//            UserDBHandler db = new UserDBHandler(context);
//            User user;
//            String email = "";
//            user = db.getUser(email);  // using current user EMAIL
//            emailTxt.setText(user.getEmail());
//        }catch (SQLException e){
//            Log.w("Profile", "onClick: ", e);
//        }



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // update database
                emailStr = emailTxt.getText().toString();
                fnameStr = fnameTxt.getText().toString();

                Update up = new Update();
                up.execute();



            }
        });

        return v;
    }

    class Update extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            serviceHandler = new ServiceHandler();
            String url = "http://rescueproject2016.netne.net/myPHP/update.php";
            response = serviceHandler.UpdateService(url,emailStr,fnameStr);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            response=response.trim();
            Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
        }
    }

}
