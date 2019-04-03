package com.ahmed.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showNotification();
            }
        });
    }

    private void showNotification(){

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel = new NotificationChannel("abc","My Channcel",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);

            builder = new Notification.Builder(this,"abc");
        }
        else {
            builder = new Notification.Builder(this);
        }

        builder.setContentTitle("My App");
        builder.setContentText("Welcome " + String.valueOf(new Random().nextInt(50)));
        builder.setSmallIcon(R.drawable.baseline_mail_outline_black_36);

        Intent intent = new Intent(this,HomeActivity.class);
        intent.putExtra("data", "HeLLo !!");
        PendingIntent pending = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Intent intent2 = new Intent(this,HomeActivity.class);
        intent2.putExtra("data", "LIKE ACTION");
        PendingIntent pending2 = PendingIntent.getActivity(this,1,intent2,PendingIntent.FLAG_ONE_SHOT);

        Intent intent3 = new Intent(this,HomeActivity.class);
        intent3.putExtra("data", "REPLAY ACTION");
        PendingIntent pending3 = PendingIntent.getActivity(this,2,intent3,PendingIntent.FLAG_ONE_SHOT);

        builder.setContentIntent(pending);

        builder.addAction(0,"Like",pending2);
        builder.addAction(0,"Replay",pending3);

        Notification notification = builder.build();

        manager.notify(100,notification);
    }

}
