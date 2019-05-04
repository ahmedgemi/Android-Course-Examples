package com.ahmed.musicplayer;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MediaService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        MyApp.getInstance().startSong();

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder;

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){

            NotificationChannel channel = new NotificationChannel("abc","Channel", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);

            builder = new Notification.Builder(getApplicationContext(),"abc");
        }
        else {
            builder = new Notification.Builder(getApplicationContext());
        }

        builder.setContentTitle("Service");
        builder.setContentText("Service is running ...");
        builder.setSmallIcon(R.drawable.ic_launcher_background);

        Intent intent1 = new Intent(this,MediaBroadCast.class);
        intent1.putExtra("type",0);
        PendingIntent pending1 = PendingIntent.getBroadcast(this,1,intent1,0);

        Intent intent2 = new Intent(this,MediaBroadCast.class);
        intent2.putExtra("type",1);
        PendingIntent pending2 = PendingIntent.getBroadcast(this,2,intent2,0);

        Intent intent3 = new Intent(this,MediaBroadCast.class);
        intent3.putExtra("type",2);
        PendingIntent pending3 = PendingIntent.getBroadcast(this,3,intent3,0);

        builder.addAction(0,"Play",pending1);
        builder.addAction(0,"Pause",pending2);
        builder.addAction(1,"Stop",pending3);


        Notification notification = builder.build();

        startForeground(100,notification);


        return START_STICKY;
    }
}
