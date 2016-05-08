package com.sam.amman.rescue.Normal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sam.amman.rescue.Adapters.SympListFragAdapter;
import com.sam.amman.rescue.R;

import java.util.ArrayList;

/**
 * Created by SAM on 4/26/2016.
 */
public class DiagnosesListfrag extends ListFragment {

    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.diagnoses_list,container,false);
        String[] datasource={"do this","do that","don't do"};


        SympListFragAdapter ad=new SympListFragAdapter(new ArrayList<String>(), getActivity());
        ad.addAll(datasource);
        setListAdapter(ad);

        //setRetainInstance(true);


        return v;
    }
}
