package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate(){
        super.onCreate();
        Log.d("MyService","onCreate executed");
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("MyService","onStartCommand executed");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("MyService","创建子线程，子线程的id号为：" + Thread.currentThread().getId());
                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d("MyService","onDestroy executed");
    }
}
