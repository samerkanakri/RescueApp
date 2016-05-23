package com.sam.amman.rescue.Doctor_Fragments;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.sam.amman.rescue.Adapters.CallDoctor_ListFrag;
import com.sam.amman.rescue.R;

public class CaseResponde extends AppCompatActivity {

    ListView categoriesLst;
    Button BtnResponde,cancelBtn;
    View v;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_case_response);

        Toast.makeText(this, "created",Toast.LENGTH_SHORT).show();

        BtnResponde = (Button) findViewById(R.id.BtnResponde);
        cancelBtn = (Button) findViewById(R.id.CancelCaseBtn);

        final String[] datasource1={"Do this"
                ,"Do that"
                ,"Don't do this"};

        BtnResponde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"response will be sent", Toast.LENGTH_LONG).show();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CaseResponde.this.finish();
            }
        });

//        CallDoctor_ListFrag a = new CallDoctor_ListFrag();
//        a.setDatasource(datasource1);
//        FragmentTransaction tr = getSupportFragmentManager().beginTransaction().replace(R.id.sympListFrame,a);
//        tr.commit();
    }



}
