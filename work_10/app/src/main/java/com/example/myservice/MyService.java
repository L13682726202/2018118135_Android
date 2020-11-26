package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private boolean flag = true;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
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
                while(flag){
                    Log.d("MyService","子线程的id号：" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy(){
        super.onDestroy();
        flag = false;
        Log.d("MyService","onDestroy executed");
    }
}
