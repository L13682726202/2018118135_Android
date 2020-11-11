package com.example.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;

public class BaseActivity extends AppCompatActivity {

    private ForceOfflineReceiver receiver;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class ForceOfflineReceiver extends BroadcastReceiver{
        public void onReceive(final Context context, Intent intent){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline. Please try to login again.");
            builder.setCancelable(false);
            builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
               public void onClick(DialogInterface dialog, int which){
                   ActivityCollector.finishAll();
                   Intent intent = new Intent(context, LoginActivity.class);
                   context.startActivity(intent);
               }
            });
            builder.show();
        }
    }
}
