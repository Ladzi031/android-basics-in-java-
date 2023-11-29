package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyBoundedService myBService;
    MyBoundedService.MyBoundedServiceBinder myBinder;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, MyBoundedService.class);
        bindService(i, serviceConnection, Context.BIND_AUTO_CREATE);
    }
    public void showTime(View view){
        TextView textView = findViewById(R.id.textView);
        String currentTime = myBService.getCurrentDate();
        textView.setText(currentTime);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        // maintains a cleaner connection channel between "this" activity and the Bounded Service
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MyBoundedService.MyBoundedServiceBinder) iBinder;
            myBService = myBinder.getBoundedService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };
}
