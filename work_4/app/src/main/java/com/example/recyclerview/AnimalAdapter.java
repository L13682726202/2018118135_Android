package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private List<Animal> mAnimalList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView animalImage;
        EditText animalName;

        public ViewHolder(View view){
            super(view);
            animalImage = (ImageView)view.findViewById(R.id.animal_image);
            animalName = (EditText)view.findViewById(R.id.animal_name);
        }
    }

    public AnimalAdapter(List<Animal> animalList){
        mAnimalList = animalList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        Animal animal = mAnimalList.get(position);
        holder.animalImage.setImageResource(animal.getImageId());
        holder.animalName.setText(animal.getName());
    }

    public int getItemCount(){
        return mAnimalList.size();
    }
}
