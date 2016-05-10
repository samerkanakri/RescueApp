package com.sam.amman.rescue.Normal;

import android.content.Context;
import android.database.SQLException;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sam.amman.rescue.Actors.User;
import com.sam.amman.rescue.Adapters.DBHandler;
import com.sam.amman.rescue.Adapters.UserDBHandler;
import com.sam.amman.rescue.R;

public class Profile extends Fragment {

    Context context;
    View v;
    Button submit;
    EditText emailTxt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_profile,container,false);

        emailTxt = (EditText) v.findViewById(R.id.emailEdtxt);


        //get current user data
        try {
            UserDBHandler db = new UserDBHandler(context);
            User user;
            String email = "";
            user = db.getUser(email);  // using current user EMAIL
            emailTxt.setText(user.getEmail());
        }catch (SQLException e){
            Log.w("Profile", "onClick: ", e);
        }


        submit = (Button) v.findViewById(R.id.BtnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // update database


            }
        });

        return v;
    }

}
