package com.ahmed.musicplayer;

import android.app.Application;
import android.media.MediaPlayer;

public class MyApp extends Application {

    private static MyApp app;

    public MediaPlayer mediaPlayer;

    public static MyApp getInstance(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        mediaPlayer =MediaPlayer.create(this,R.raw.sound);
        mediaPlayer.setLooping(true);
    }

    public void startSong(){
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        }

        mediaPlayer.start();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }






















}
