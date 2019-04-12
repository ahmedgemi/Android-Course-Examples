package com.ahmed.tasktrackingexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class Utils {

    public static void showNotification(Context context, String title, String msg){

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder;

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){

            NotificationChannel channel = new NotificationChannel("abc","Notify",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);

            builder = new Notification.Builder(context,"abc");
        }
        else{
            builder = new Notification.Builder(context);
        }

        builder.setContentTitle(title);
        builder.setContentText(msg);
        builder.setSmallIcon(R.mipmap.ic_launcher);

        manager.notify(100,builder.build());
    }
}
