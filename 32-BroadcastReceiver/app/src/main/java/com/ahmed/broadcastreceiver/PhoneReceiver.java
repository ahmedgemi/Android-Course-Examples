package com.ahmed.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class PhoneReceiver extends BroadcastReceiver {

    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;

        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        PhoneListener listener = new PhoneListener();

        manager.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }


    public class PhoneListener extends PhoneStateListener {

        @Override
        public void onCallStateChanged(int state, String phoneNumber) {

            switch (state){

                case TelephonyManager.CALL_STATE_RINGING:

                    Toast.makeText(context,"RING " + phoneNumber,Toast.LENGTH_SHORT).show();
                    break;

                case TelephonyManager.CALL_STATE_IDLE:
                    Toast.makeText(context,"IDLE",Toast.LENGTH_SHORT).show();
                    break;

                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Toast.makeText(context,"OFF",Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    }
}
