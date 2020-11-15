package com.example.download;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class DownloadService extends Service {

    private DownloadTask downloadTask;
    private String downloadUrl;

    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {

        }

        @Override
        public void onSuccess() {

        }

        @Override
        public void onFailed() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onCanceled() {

        }
    }

    private DownloadBinder

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }


}
