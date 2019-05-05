package com.ahmed.fcmandgooglelogin;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FCMService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String s) {
        System.out.println();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // make custom action
    }
}
