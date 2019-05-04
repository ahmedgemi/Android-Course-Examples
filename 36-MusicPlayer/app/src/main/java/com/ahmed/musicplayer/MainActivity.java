package com.ahmed.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void startService(){
        Intent intent = new Intent(this,MediaService.class);
        startService(intent);
    }

    @OnClick(R.id.button2)
    public void play(){
        MyApp.getInstance().mediaPlayer.start();
    }

    @OnClick(R.id.button3)
    public void pause(){
        MyApp.getInstance().mediaPlayer.pause();
    }


}
