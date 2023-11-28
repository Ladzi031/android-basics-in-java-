package com.example.myapplication9;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {

    private final String TAG = "myIntentService";
    public MyIntentService() {
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "the service has started");
        //it appears this override method has been deprecated. :(
    }
}
//general_rule_101: the logging TAG should be at most 23 CHARs long.