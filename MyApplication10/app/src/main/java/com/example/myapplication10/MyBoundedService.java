package com.example.myapplication10;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyBoundedService extends Service {
    private final IBinder myBinder = new MyBoundedServiceBinder();
    public MyBoundedService() {
    }
    public String getCurrentDate(){
        final String pattern = "EEE, d MMM yyyy HH:mm:ss";

        return new SimpleDateFormat(pattern, Locale.UK).format(new Date()).toString();
    }
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
    public class MyBoundedServiceBinder extends Binder{
        public MyBoundedService getBoundedService(){
            return MyBoundedService.this;
        }
    }
}