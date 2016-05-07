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
public class SympListFragAdapter extends BaseAdapter {
    List<String> stringList=new ArrayList<>();
    Context c;

    public SympListFragAdapter(List<String> stringList, Context c) {
        this.stringList = stringList;
        this.c = c;
    }

    public void addAll(String[] item){
        for (String i:item){
            stringList.add(i);
        }
        notifyDataSetChanged();
    }
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
