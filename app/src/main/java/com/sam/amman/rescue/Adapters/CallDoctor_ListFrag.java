package com.sam.amman.rescue.Adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.sam.amman.rescue.R;

import java.util.ArrayList;

/**
 * Created by SAM on 4/26/2016.
 */
public class CallDoctor_ListFrag extends ListFragment {

    View v;
    String [] datasource;
    CheckBox c;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frag_list_symp_call_doctor,container,false);
        c = (CheckBox) v.findViewById(R.id.checkBoxS);
        final CallDoctor_SympListFragAdapter ad=new CallDoctor_SympListFragAdapter(new ArrayList<String>(), getActivity());
        ad.addAll(getDatasource());
        setListAdapter(ad);
//

        return v;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

            Toast.makeText(getActivity(),"hi from row",Toast.LENGTH_LONG ).show();

    }

    public String[] getDatasource(){
        return datasource;
    }

    public void setDatasource(String[] datasource){
        this.datasource=datasource;
    }

}
