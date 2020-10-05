package com.example.recyclerview;

public class Animal {
    private int number;
    private String name;
    private int imageId;

    public Animal(int number, String name, int imageId){
        this.number = number;
        this.name = name;
        this.imageId = imageId;
    }

    public int getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
