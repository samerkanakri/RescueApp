package com.sam.amman.rescue.Normal;

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

import com.sam.amman.rescue.R;

public class EDoctor extends Fragment {

    ListView sympLst;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.edoctor,container,false);
        sympLst = (ListView) v.findViewById(R.id.SymptomsLst);

        //categories list
        String[] sympSource = {"1","2","3"};
        ArrayAdapter<String> sympAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, sympSource);
        sympLst.setAdapter(sympAdapter);

        final String[] datasource1={"1","2","3"};
        final String[] datasource2={"4","5","6"};
        final String[] datasource3={"7","8","9"};


        sympLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // CHANGE DATA SOURCE DEPENDING ON i
                if(i==0){
                    Listfrag a = new Listfrag();
                    a.setDatasource(datasource1);
                    FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.DiagnosesContainer,a);
                    tr.commit();
                }
                if(i==1){
                    Listfrag a = new Listfrag();
                    a.setDatasource(datasource2);
                    FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.DiagnosesContainer,a);
                    tr.commit();
                }
                if(i==2){
                    Listfrag a = new Listfrag();
                    a.setDatasource(datasource3);
                    FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.DiagnosesContainer,a);
                    tr.commit();
                }
            }
        });



        return v;
    }
}
