package com.example.myapplication11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     final TextView myText = findViewById(R.id.textView);

    // handler is used for updating UI widget when some task is done from a thread
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            myText.setText("done with Task!");
        }
    };
    public void doIntenseTask(View view) {

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    TimeUnit.SECONDS.sleep(5000); // my intense task
                }catch (InterruptedException ignored){}
                
                handler.sendEmptyMessage(0);
            }
        };

        ExecutorService executorService =  Executors.newFixedThreadPool(2);
        executorService.execute(task);
        executorService.shutdown();
    }
}