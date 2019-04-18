package com.ahmed.gps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    private FusedLocationProviderClient fusedClient;
    private LocationRequest requestSetting;
    private LocationCallback locationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        initFusedSetting();

    }

    @Override
    protected void onStart() {
        super.onStart();
        checkPermission();
    }

    @Override
    protected void onStop() {
        fusedClient.removeLocationUpdates(locationCallback);
        super.onStop();
    }

    public void initFusedSetting() {

        fusedClient = LocationServices.getFusedLocationProviderClient(this);

        requestSetting = LocationRequest.create();
        requestSetting.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        requestSetting.setInterval(4000);
        requestSetting.setFastestInterval(2000);

        locationCallback = new LocationCallback() {

            @Override
            public void onLocationResult(LocationResult locationResult) {

                Location myLocation = locationResult.getLastLocation();

                String s = String.valueOf(myLocation.getLatitude()) + " - " + String.valueOf(myLocation.getLongitude());
                textView.setText(s);

                Log.d("my location", s);
            }
        };
    }

    public void checkPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            }
        } else {
            getLocation();
        }
    }

    public void getLocation() {

        fusedClient.requestLocationUpdates(requestSetting, locationCallback, null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            getLocation();
        }
    }


}
