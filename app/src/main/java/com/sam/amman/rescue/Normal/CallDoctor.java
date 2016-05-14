package com.sam.amman.rescue.Normal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.sam.amman.rescue.R;



public class CallDoctor extends Fragment {

    ListView categoriesLst;
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

        //categories list
        categoriesLst = (ListView) v.findViewById(R.id.catLst);
        String[] sympSource = {"1","2","3"};
        ArrayAdapter<String> sympAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, sympSource);
        categoriesLst.setAdapter(sympAdapter);


        categoriesLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // CHANGE DATA SOURCE DEPENDING ON i

                //symptoms list
                Fragment frg = new SymptomsListfrag();
                FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.sympListFrame,frg);
                tr.commit();
            }
        });


        return v;
    }
}
