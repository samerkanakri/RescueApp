package com.sam.amman.rescue;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sam.amman.rescue.Adapters.DBHandler;
import com.sam.amman.rescue.Adapters.UserDBHandler;

public class RegActivity extends AppCompatActivity {


    UserDBHandler db;
    Spinner spinner;
    Button reg;
    EditText emailEdt,passwordEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        emailEdt = (EditText) findViewById(R.id.email);
        passwordEdt = (EditText) findViewById(R.id.password);
        reg = (Button) findViewById(R.id.BtnReg);
        db = new UserDBHandler(this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //saving
                String emailStr = emailEdt.getText().toString();
                String passwordStr = passwordEdt.getText().toString();
                if("".equals(emailStr) || "".equals(passwordStr)){
                    Log.w("Registration ", "onClick: ",null );
                }else{
                    try {
                        db = new UserDBHandler(getApplication());
//                        User user = new User();
//                        user.setEmail(usernameEdt.getText().toString());
//                        user.setPassword(password.getText().toString());
//                        db.addUser(user);
                        db.addUserStr(emailStr,passwordStr);
                        db.close();
                        Toast.makeText(RegActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.w(" --- ", "onClick: ",e );
                        Toast.makeText(RegActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
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
