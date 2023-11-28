package com.example.sendbroadcastintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendBroadcastIntent(View view){
        Intent i = new Intent()
                .setAction("com.example.sendBroadcastIntentApp")
                .addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES); //support most devices
        sendBroadcast(i);
        Snackbar.make(
                view,
                "broadcast is sent!",
                Snackbar.LENGTH_SHORT).show();
    }
}