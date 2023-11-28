package com.example.myapplication9;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyService extends Service {

    private final String TAG = "MyService";
    public MyService(){

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // mimic some unit of work...
                for(int i = 0; i < 5; i++){
                    long futureTime = System.currentTimeMillis() + 5000;
                    while(System.currentTimeMillis() < futureTime){
                        synchronized (this) {
                            try{
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG, "service is doing some intense unit of work");
                            }catch(Exception ignored){}
                        }
                    }
                }

            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(r);
        executorService.shutdown();

       return Service.START_STICKY; // tells android to: attempt to recreate this service after being killed...
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "service is destroyed :(");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;  // this becomes a non-bounded service
    }
}
