package com.sam.amman.rescue.Adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
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
public class Listfrag extends ListFragment {

    View v;
    String [] datasource;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.symptoms_list,container,false);

        SympListFragAdapter ad=new SympListFragAdapter(new ArrayList<String>(), getActivity());
        ad.addAll(getDatasource());
        setListAdapter(ad);

        return v;
    }


    public String[] getDatasource(){
        return datasource;
    }

    public void setDatasource(String[] datasource){
        this.datasource=datasource;
    }

}
