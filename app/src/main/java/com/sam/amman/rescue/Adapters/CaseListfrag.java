package com.sam.amman.rescue.Adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sam.amman.rescue.Adapters.CaseListFragAdapter;
import com.sam.amman.rescue.Adapters.SympListFragAdapter;
import com.sam.amman.rescue.R;

import java.util.ArrayList;

/**
 * Created by SAM on 4/26/2016.
 */
public class CaseListfrag extends ListFragment {

    View v;
//    String [] datasource;
    ArrayList<String> datasource;
    ListView symList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.symptoms_list,container,false);
        symList = (ListView) v.findViewById(android.R.id.list);
        CaseListFragAdapter ad=new CaseListFragAdapter(new ArrayList<String>(), getActivity());
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

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(),"hi",Toast.LENGTH_LONG).show();


    }

    public ArrayList<String> getDatasource(){
        return datasource;
    }

    public void setDatasource(ArrayList<String> datasource){
        this.datasource=datasource;
    }

}
