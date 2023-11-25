package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;



//each activity has a lifeCycle...

/*
Log.i(TAG,sMessage)...
Tag is can be used to identify a specific log under logCat section,
which helps debugging...
*/

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "LadziMessages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart called");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "onPause called");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "onResume called");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy called");
    }
}