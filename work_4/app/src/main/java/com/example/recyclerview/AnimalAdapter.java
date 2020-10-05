package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private List<Animal> mAnimalList;
    private EditText lastEditText;
    private int flag = 0;
    private double startTime;
    private int times = 0;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View animalView;
        TextView animalNumber;
        ImageView animalImage;
        EditText animalName;

        public ViewHolder(View view){
            super(view);
            animalView = view;
            animalNumber = (TextView)view.findViewById(R.id.animal_number);
            animalImage = (ImageView)view.findViewById(R.id.animal_image);
            animalName = (EditText)view.findViewById(R.id.animal_name);
        }
    }

    public AnimalAdapter(List<Animal> animalList){
        mAnimalList = animalList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.animalView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(flag == 0){
                    flag = 1;
                    lastEditText = holder.animalName;
                }
                else{
                    lastEditText.setFocusable(false);
                    lastEditText.setFocusableInTouchMode(false);
                    lastEditText = holder.animalName;
                    holder.animalName.setFocusable(false);
                    holder.animalName.setFocusableInTouchMode(false);
                }
                int position = holder.getAdapterPosition();
                Animal animal = mAnimalList.get(position);
                Toast.makeText(v.getContext(),"你点击了" + animal.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.animalNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 0){
                    flag = 1;
                    lastEditText = holder.animalName;
                }
                else{
                    lastEditText.setFocusable(false);
                    lastEditText.setFocusableInTouchMode(false);
                    lastEditText = holder.animalName;
                    holder.animalName.setFocusable(false);
                    holder.animalName.setFocusableInTouchMode(false);
                }
                int position = holder.getAdapterPosition();
                Animal animal = mAnimalList.get(position);
                Toast.makeText(v.getContext(),"你点击了" + animal.getName() + "的编号",Toast.LENGTH_SHORT).show();
            }
        });
        holder.animalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 0){
                    flag = 1;
                    lastEditText = holder.animalName;
                }
                else{
                    lastEditText.setFocusable(false);
                    lastEditText.setFocusableInTouchMode(false);
                    lastEditText = holder.animalName;
                    holder.animalName.setFocusable(false);
                    holder.animalName.setFocusableInTouchMode(false);
                }
                int position = holder.getAdapterPosition();
                Animal animal = mAnimalList.get(position);
                Toast.makeText(v.getContext(),"你点击了" + animal.getName() + "的图片",Toast.LENGTH_SHORT).show();
            }
        });
        holder.animalName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 0){
                    flag = 1;
                    lastEditText = holder.animalName;
                    holder.animalName.setFocusableInTouchMode(true);
                    holder.animalName.setFocusable(true);
                    holder.animalName.requestFocus();
                }
                else{
                    lastEditText.setFocusable(false);
                    lastEditText.setFocusableInTouchMode(false);
                    lastEditText = holder.animalName;
                }
                if(times == 0){
                    times = 1;
                    startTime = System.currentTimeMillis();
                    int position = holder.getAdapterPosition();
                    Animal animal = mAnimalList.get(position);
                    Toast.makeText(v.getContext(),"你点击了" + animal.getName() + "的文字",Toast.LENGTH_SHORT).show();
                }
                else{
                    double endTime = System.currentTimeMillis();
                    if((endTime - startTime) <= 500){
                        times = 0;
                        holder.animalName.setFocusableInTouchMode(true);
                        holder.animalName.setFocusable(true);
                        holder.animalName.requestFocus();
                    }
                    else{
                        startTime = System.currentTimeMillis();
                        int position = holder.getAdapterPosition();
                        Animal animal = mAnimalList.get(position);
                        Toast.makeText(v.getContext(),"你点击了" + animal.getName() + "的文字",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        Animal animal = mAnimalList.get(position);
        holder.animalNumber.setText(animal.getNumber());
        holder.animalImage.setImageResource(animal.getImageId());
        holder.animalName.setText(animal.getName());
    }

    public int getItemCount(){
        return mAnimalList.size();
    }
}
