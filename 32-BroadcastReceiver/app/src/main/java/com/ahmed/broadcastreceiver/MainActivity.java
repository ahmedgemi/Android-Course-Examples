package com.ahmed.broadcastreceiver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    GPSReceiver receiver = new GPSReceiver();

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register();
        checkPermission();

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unReister();
            }
        });


        Calendar calendar = Calendar.getInstance();

        calendar.getTimeInMillis();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        String date = dateFormat.format(calendar.getTime());

        Toast.makeText(this,date,Toast.LENGTH_LONG).show();
    }

    private void register(){

        IntentFilter intentFilter = new IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION);

        registerReceiver(receiver,intentFilter);
    }

    private void unReister(){

        unregisterReceiver(receiver);
    }

    private void checkPermission(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},100);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

        }
    }
}
