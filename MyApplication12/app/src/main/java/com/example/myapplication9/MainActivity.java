package com.example.myapplication9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentService = new Intent(this, MyIntentService.class);
        startService(intentService);

        Intent myService = new Intent(this, MyService.class);
        startService(myService);
    }

    //onclick event set on the button in this activity...(allows us to switch to the bacon activity)
    public void onClick(View view){

        Intent goToActivity = new Intent(this, BaconActivity.class);
        EditText inputText =  findViewById(R.id.input_text_id);
        String name = inputText.getText().toString();
        goToActivity.putExtra("inputName", name);
        startActivity(goToActivity);
        inputText.setText(null);
    }
}