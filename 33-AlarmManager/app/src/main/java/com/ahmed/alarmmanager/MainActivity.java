package com.ahmed.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm();
            }
        });

    }

    private void setAlarm(){

//        Intent intent = new Intent(this,HomeActivity.class);
//        PendingIntent pending = PendingIntent.getActivity(this,0,intent,0);

        Intent intent = new Intent(this,AlarmReceiver.class);
        intent.setAction("com.myapp.alarm");

        PendingIntent pending = PendingIntent.getBroadcast(this,0,intent,0);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,10);

        long time = calendar.getTimeInMillis();

        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        manager.set(AlarmManager.RTC,time,pending);
    }
}
