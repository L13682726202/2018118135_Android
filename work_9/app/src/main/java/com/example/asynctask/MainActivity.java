package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DownloadTask downloadTask;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("AsyncTask");

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                downloadTask = new DownloadTask();
                progressDialog = new ProgressDialog(this);
                downloadTask.execute();
                break;
            default:
                break;
        }
    }

    public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

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