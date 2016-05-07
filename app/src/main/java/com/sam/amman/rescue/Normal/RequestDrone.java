package com.sam.amman.rescue.Normal;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sam.amman.rescue.R;


public class RequestDrone extends Fragment {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.call_doctor);
//
//
//    }


    View v;
    TextView loc ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.request_drone,container,false);
        loc = (TextView)v.findViewById(R.id.textViewLoc);
        v.findViewById(R.id.ImgBtnReqDrone).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

                LocationListener locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        Toast.makeText(getActivity(),location.toString(), Toast.LENGTH_LONG).show();

                        loc.setText(LocationToString(location.toString()));

                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                };


                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1000, locationListener);

            }
        });
        return v;


    }

    private String LocationToString(String str){
        str.trim();
        int i = str.indexOf(" ");
        str = str.substring(i,36);

        return str;
    }


}
