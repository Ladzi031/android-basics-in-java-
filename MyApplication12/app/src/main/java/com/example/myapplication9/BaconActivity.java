package com.example.myapplication9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BaconActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);

        Bundle intentBundle = getIntent().getExtras();
        if(intentBundle == null){
            return;
        }
        String username = intentBundle.getString("inputName");
        TextView display = findViewById(R.id.bacon_textview);
        display.setText("hello, "+ username);
    }
    public void onclick(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}