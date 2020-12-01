package com.example.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private Context mContext;
    private List<Animal> mAnimalList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView animalImage;
        TextView animalName;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView)view;
            animalImage = (ImageView)view.findViewById(R.id.animal_image);
            animalName = (TextView)view.findViewById(R.id.animal_name);
        }
    }

    public AnimalAdapter(List<Animal> animalList){
        mAnimalList = animalList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.animal_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Animal animal = mAnimalList.get(position);
                Intent intent = new Intent(mContext, AnimalActivity.class);
                intent.putExtra(AnimalActivity.ANIMAL_NAME, animal.getName());
                intent.putExtra(AnimalActivity.ANIMAL_IMAGE_ID, animal.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Animal animal = mAnimalList.get(position);
        holder.animalName.setText(animal.getName());
        Glide.with(mContext).load(animal.getImageId()).into(holder.animalImage);
    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }
}
