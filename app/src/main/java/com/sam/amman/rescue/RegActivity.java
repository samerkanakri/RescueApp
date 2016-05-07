package com.sam.amman.rescue;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sam.amman.rescue.Actors.User;
import com.sam.amman.rescue.Adapters.DataBaseHandler;

public class RegActivity extends AppCompatActivity {


    DataBaseHandler db;
    Spinner spinner;
    Button reg;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        username = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.password);
        reg = (Button) findViewById(R.id.BtnReg);
        db = new DataBaseHandler(this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //saving
                db = new DataBaseHandler(getApplication());


                try {

                    db.addUserStr("samer","123");
                    db.close();
                    Toast.makeText(RegActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.w(" --- ", "onClick: ",e );
                    Toast.makeText(RegActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


//        spinner = (Spinner) findViewById(R.id.spinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.country_codes, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
