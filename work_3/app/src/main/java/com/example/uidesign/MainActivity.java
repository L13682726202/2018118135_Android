package com.example.uidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("UI Design");

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);
        Button button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener(this);
        Button button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(this);
        EditText editText = (EditText)findViewById(R.id.editText);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button1:
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
        }
    }
}