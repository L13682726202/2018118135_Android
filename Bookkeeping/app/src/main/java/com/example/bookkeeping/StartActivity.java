package com.example.bookkeeping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StartActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGHT = 3000;

    private List<String> list_1 = new ArrayList<String>();
    private List<String> list_2 = new ArrayList<String>();

    private TextView textView_1;
    private TextView textView_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        textView_1 = findViewById(R.id.start_tv2);
        textView_2 = findViewById(R.id.start_tv3);

        addText();
        Random random = new Random();
        int i = random.nextInt(list_1.size());

        textView_1.setText(list_1.get(i));
        textView_2.setText(list_2.get(i));

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                StartActivity.this.startActivity(intent);
                StartActivity.this.finish();
            }
        },SPLASH_DISPLAY_LENGHT);
    }

    public void addText(){
        list_1.add("学会管理好自己的钱");
        list_2.add("也是一种智慧");
        list_1.add("别想一下造出大海");
        list_2.add("必须先由小河川开始");
        list_1.add("莫让一时的懒惰");
        list_2.add("毁了你坚持许久的成果");
        list_1.add("人生伟业的建立");
        list_2.add("不在能知，乃在能行");
        list_1.add("即使是不成熟的尝试");
        list_2.add("也胜于胎死腹中的策略");
        list_1.add("精打细算，记录生活");
        list_2.add("不忘初心，方得始终");
    }
}