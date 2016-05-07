package com.sam.amman.rescue.Normal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sam.amman.rescue.R;


public class CallDoctor extends Fragment {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.call_doctor);
//
//
//    }


    Button BtnSendSymp;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.call_doctor,container,false);

        v.findViewById(R.id.BtnSendSymp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Symptoms will be sent", Toast.LENGTH_LONG).show();
            }
        });


        Fragment fr = new SymptomsListfrag();
        FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.sympListFrame,fr);
        tr.commit();
        return v;
    }
}
