package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.setTitle("SecondActivity");

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onStart(){
        super.onStart();
        Log.d("SecondActivity","onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d("SecondActivity","onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d("SecondActivity","onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d("SecondActivity","onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("SecondActivity","onDestroy");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d("SecondActivity","onRestart");
    }
}