package com.ahmed.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button,button2;
    ProgressBar progressBar;

    MyTask task = new MyTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                task.execute();
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                task.cancel(true);
            }
        });
    }


    public class MyTask extends AsyncTask<Void,Integer,Void>{

        @Override
        protected void onPreExecute() {

            Toast.makeText(MainActivity.this,"Timer Start",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            for(int i=0; i<100; i++){

                publishProgress(i);

                if (isCancelled()){
                    return null;
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            textView.setText(String.valueOf(values[0]));
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(MainActivity.this,"Timer Finish",Toast.LENGTH_SHORT).show();

        }
    }

}
