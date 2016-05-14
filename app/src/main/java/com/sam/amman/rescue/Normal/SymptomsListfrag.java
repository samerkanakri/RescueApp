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
public class SymptomsListfrag extends ListFragment {

    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.symptoms_list,container,false);

        String[] datasource1={"1","2","3"};
        String[] datasource2={"4","5","6"};
        String[] datasource3={"7","8","9"};

        SympListFragAdapter ad=new SympListFragAdapter(new ArrayList<String>(), getActivity());
        ad.addAll(datasource1);
        setListAdapter(ad);

        return v;
    }


}
