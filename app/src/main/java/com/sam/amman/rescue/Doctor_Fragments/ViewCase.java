package com.sam.amman.rescue.Doctor_Fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.sam.amman.rescue.R;

public class ViewCase extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_view_case);

        Intent i = getIntent();
        int cid = i.getIntExtra("CID",-1);

        if(cid<1){
            this.finish();
        }else{
            Toast.makeText(this,"Case " + cid + " is loading",Toast.LENGTH_SHORT).show();
        }
    }
}
