package com.sam.amman.rescue.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sam.amman.rescue.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAM on 4/20/2016.
 */
public class CaseListFragAdapter extends BaseAdapter {
    List<String> stringList=new ArrayList<>();
    Context c;

    //constructor
    public CaseListFragAdapter(List<String> stringList, Context c) {
        this.stringList = stringList;
        this.c = c;
    }

    //add list of items
    public void addAll(ArrayList<String> items){
        for (String i:items){
            stringList.add(i);
        }
        notifyDataSetChanged();
    }

    //add single item
    public void add(String item){
        stringList.add(item);

    notifyDataSetChanged();
    }



    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int i) {
        return stringList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)c.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        View v=inflater.inflate(R.layout.symprow,null);

        ((TextView)v.findViewById(R.id.TxtCaseTitle)).setText(stringList.get(i));




        return v;
    }
}
