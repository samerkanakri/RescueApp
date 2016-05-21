package com.sam.amman.rescue.Adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sam.amman.rescue.R;

import java.util.ArrayList;

/**
 * Created by SAM on 4/26/2016.
 */
public class E_Doctor_ListFrag extends ListFragment {

    View v;
//    String [] datasource;
    ArrayList<String> datasource;
    ListView symList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frag_list,container,false);
        symList = (ListView) v.findViewById(android.R.id.list);
        E_Doctor_ListFragAdapter ad=new E_Doctor_ListFragAdapter(new ArrayList<String>(), getActivity());
        // replace getDatasource() with you String arrayList
        ad.addAll(getDatasource());
        setListAdapter(ad);

//        symList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getActivity(),"hi",Toast.LENGTH_LONG).show();
//            }
//        });

        return v;
    }



    public ArrayList<String> getDatasource(){
        return datasource;
    }

    public void setDatasource(ArrayList<String> datasource){
        this.datasource=datasource;
    }

}
