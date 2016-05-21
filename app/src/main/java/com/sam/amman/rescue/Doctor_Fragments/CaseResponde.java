package com.sam.amman.rescue.Doctor_Fragments;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.PersistableBundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.Toast;

        import com.sam.amman.rescue.Adapters.CallDoctor_ListFrag;
        import com.sam.amman.rescue.NavigationMain;
        import com.sam.amman.rescue.R;


public class CaseResponde extends AppCompatActivity {

    ListView categoriesLst;
    Button BtnResponde,cancelBtn;
    View v;
    final String[] datasource1={"Do this"
            ,"Do that"
            ,"Don't do this"};

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_case_response);

        BtnResponde = (Button) findViewById(R.id.BtnResponde);
        cancelBtn = (Button) findViewById(R.id.CancelCaseBtn);

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

        CallDoctor_ListFrag a = new CallDoctor_ListFrag();
        a.setDatasource(datasource1);
        FragmentTransaction tr = getSupportFragmentManager().beginTransaction().replace(R.id.sympListFrame,a);
        tr.commit();

    }

}
