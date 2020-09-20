package com.example.chapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        this.setTitle("ThirdActivity");

        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ThirdActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ThirdActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onStart(){
        super.onStart();
        Log.d("ThirdActivity","onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d("ThirdActivity","onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d("ThirdActivity","onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d("ThirdActivity","onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("ThirdActivity","onDestroy");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d("ThirdActivity","onRestart");
    }
}