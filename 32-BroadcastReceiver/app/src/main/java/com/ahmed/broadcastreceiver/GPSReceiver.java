package com.ahmed.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class GPSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        ContentResolver contentResolver = context.getContentResolver();

        int resutl = Settings.Secure.getInt(contentResolver, Settings.Secure.LOCATION_MODE, 0);

        if(resutl == Settings.Secure.LOCATION_MODE_OFF) {
            Toast.makeText(context,"GPS OFF !!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"GPS ON !!",Toast.LENGTH_SHORT).show();
        }
    }
}
