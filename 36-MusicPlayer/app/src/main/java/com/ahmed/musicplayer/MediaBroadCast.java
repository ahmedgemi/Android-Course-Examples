package com.ahmed.musicplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MediaBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int type = intent.getExtras().getInt("type");

        if(type == 0){
            MyApp.getInstance().mediaPlayer.start();
        }
        else if(type == 1){
            MyApp.getInstance().mediaPlayer.pause();
        }
        else if(type == 2){
            MyApp.getInstance().mediaPlayer.stop();

            Intent intent1 = new Intent(context,MediaService.class);
            context.stopService(intent1);
        }
    }
}
