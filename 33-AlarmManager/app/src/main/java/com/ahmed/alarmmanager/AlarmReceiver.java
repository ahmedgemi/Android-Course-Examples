package com.ahmed.alarmmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("abc","alarm",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);

            builder = new Notification.Builder(context,"abc");
        }
        else {
            builder = new Notification.Builder(context);
        }

        builder.setContentTitle("Alarm");
        builder.setContentText("Alarm Started !!!");
        builder.setSmallIcon(R.drawable.ic_launcher_background);

        manager.notify(111,builder.build());
    }
}
