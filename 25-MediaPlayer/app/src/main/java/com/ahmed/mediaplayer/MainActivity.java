package com.ahmed.mediaplayer;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;

    Button button,button2;
    TextView textView, textView_vol;
    SeekBar seekBar,seekBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.sound);

        button = findViewById(R.id.button_start);
        button.setOnClickListener(this);

        button2 = findViewById(R.id.button_pause);
        button2.setOnClickListener(this);

        textView = findViewById(R.id.textView);
        textView_vol = findViewById(R.id.textView_vol);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textView_vol.setText(String.valueOf(progress));

                float vol = (float) progress / 100;

                mediaPlayer.setVolume(vol,vol);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar2 = findViewById(R.id.seekBar3);
        seekBar2.setMax(mediaPlayer.getDuration());
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(fromUser){

                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button_start:
                MediaTask task = new MediaTask();
                task.execute();
                mediaPlayer.start();
                break;

            case R.id.button_pause:
                mediaPlayer.pause();
                break;
        }
    }

    public class MediaTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            while (mediaPlayer.isPlaying()){
                publishProgress();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {

            Date date = new Date();
            date.setTime(mediaPlayer.getCurrentPosition());
            date.getMinutes();

            seekBar2.setProgress(mediaPlayer.getCurrentPosition());
            textView.setText(String.valueOf(date.getMinutes()) + ":" + String.valueOf(date.getSeconds()));
        }
    }

}
