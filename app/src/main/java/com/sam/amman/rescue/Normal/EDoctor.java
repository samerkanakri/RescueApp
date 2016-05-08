package com.sam.amman.rescue.Normal;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


        Fragment frg = new DiagnosesListfrag();
        FragmentTransaction tr = getChildFragmentManager().beginTransaction().replace(R.id.DiagnosesContainer,frg);
        tr.commit();

        return v;
    }
}
