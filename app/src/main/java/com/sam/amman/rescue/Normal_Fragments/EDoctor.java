package com.sam.amman.rescue.Normal_Fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sam.amman.rescue.Adapters.CallDoctor_ListFrag;
import com.sam.amman.rescue.R;

public class EDoctor extends Fragment {

    ListView sympLst;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_e_doctor,container,false);
        sympLst = (ListView) v.findViewById(R.id.SymptomsLst);

        //categories list
        String[] sympSource = {"First degree burn","2","3"};
        ArrayAdapter<String> sympAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, sympSource);
        sympLst.setAdapter(sympAdapter);

        final String[] datasource1={"Swelling and redness of the injured area"
                ,"Pain develops"
                ,"Burned area becomes white on touch"};
        final String[] datasource2={"4","5","6"};
        final String[] datasource3={"7","8","9"};


        sympLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // CHANGE DATA SOURCE DEPENDING ON i
                if(i==0){
                    CallDoctor_ListFrag a = new CallDoctor_ListFrag();
                    a.setDatasource(datasource1);
                    FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.DiagnosesContainer,a);
                    tr.commit();
                }
                if(i==1){
                    CallDoctor_ListFrag a = new CallDoctor_ListFrag();
                    a.setDatasource(datasource2);
                    FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.DiagnosesContainer,a);
                    tr.commit();
                }
                if(i==2){
                    CallDoctor_ListFrag a = new CallDoctor_ListFrag();
                    a.setDatasource(datasource3);
                    FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.DiagnosesContainer,a);
                    tr.commit();
                }
            }
        });



        return v;
    }
}