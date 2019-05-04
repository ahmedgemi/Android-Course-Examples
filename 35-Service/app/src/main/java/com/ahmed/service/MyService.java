package com.ahmed.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.widget.TabHost;
import android.widget.Toast;

public class MyService extends Service {

    MyTask task;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        task = new MyTask();
        task.execute();


        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder;

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){

            NotificationChannel channel = new NotificationChannel("abc","Channel",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);

            builder = new Notification.Builder(getApplicationContext(),"abc");
        }
        else {
            builder = new Notification.Builder(getApplicationContext());
        }

        builder.setContentTitle("Service");
        builder.setContentText("Service is running ...");
        builder.setSmallIcon(R.drawable.ic_launcher_background);

        Notification notification = builder.build();

        startForeground(100,notification);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        task.cancel(true);
        Toast.makeText(getApplicationContext(),"Service Destroy",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    public class MyTask extends AsyncTask<Void,Integer,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            for (int i=0; i<10; i++){

                publishProgress(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Toast.makeText(getApplicationContext(),String.valueOf(values[0]),Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            stopSelf();
        }
    }
}
