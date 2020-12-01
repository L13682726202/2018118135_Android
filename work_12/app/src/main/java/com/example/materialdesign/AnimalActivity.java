package com.example.materialdesign;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class AnimalActivity extends AppCompatActivity {

    public static final String ANIMAL_NAME = "animal_name";
    public static final String ANIMAL_IMAGE_ID = "animal_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Intent intent = getIntent();
        String animalName = intent.getStringExtra(ANIMAL_NAME);
        int animalImageId = intent.getIntExtra(ANIMAL_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView animalImageView = (ImageView)findViewById(R.id.animal_image_view);
        TextView animalContentText = (TextView)findViewById(R.id.animal_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(animalName);
        Glide.with(this).load(animalImageId).into(animalImageView);
        String animalContent = generateAnimalContent(animalName);
        animalContentText.setText(animalContent);
    }

    private String generateAnimalContent(String animalName){
        StringBuilder animalContent = new StringBuilder();
        for(int i=0;i<500;i++){
            animalContent.append(animalName);
        }
        return animalContent.toString();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}