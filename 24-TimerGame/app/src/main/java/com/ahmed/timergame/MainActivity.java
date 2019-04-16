package com.ahmed.timergame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView_count)
    TextView textView_count;

    @BindView(R.id.textView_equ)
    TextView textView_eq;

    @BindView(R.id.editText)
    EditText editText;

    Timer timer;
    int x =0, y=0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        startTimer();
    }

    private void generateEquation(){

        x = new Random().nextInt(10);
        y = new Random().nextInt(10);

        String equ = String.valueOf(x) + " + " + String.valueOf(y);
        textView_eq.setText(equ);
    }

    private void startTimer(){
        score = 0;
        generateEquation();
        timer = new Timer();
        timer.execute();
    }

    @OnClick(R.id.button)
    public void checkResult(){

        String result = editText.getText().toString();
        if(result.isEmpty())
            return;

        int sum = Integer.valueOf(result);

        if(sum == (x+y)){
            generateEquation();
            editText.setText("");
            score++;
        }
        else {
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show();
        }
    }

    public class Timer extends AsyncTask<Void,Integer,Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            for (int i=10; i>=0; i--){

                publishProgress(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            textView_count.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("Time Up");
            builder.setMessage("Your score = " + String.valueOf(score) + "\t thank you");

            builder.setPositiveButton("Repeat Game", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startTimer();
                }
            });
            builder.show();
        }
    }

}
