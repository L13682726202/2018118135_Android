package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DownloadTask downloadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("AsyncTask");

        Button button = (Button)findViewById(R.id.button);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                downloadTask = new DownloadTask();
                downloadTask.execute();
        }
    }

    public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

        private ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

        protected void onPreExecute(){
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try{
                int i = 1;
                while(true){
                    Thread.sleep(500);
                    publishProgress(i);
                    if(i >= 100){
                        break;
                    }
                    i++;
                }
            }
            catch(Exception e){
                return false;
            }
            return true;
        }

        protected void onProgressUpdate(Integer... values){
            progressDialog.setMessage("Downloaded " + values[0] + "%");
        }

        protected void onPostExecute(Boolean result){
            progressDialog.dismiss();
            if(result){
                Toast.makeText(MainActivity.this, "Download succeeded", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Download failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}