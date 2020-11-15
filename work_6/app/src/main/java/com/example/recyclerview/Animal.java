package com.example.recyclerview;

public class Animal {
    private String number;
    private String name;
    private int imageId;

    public Animal(String number, String name, int imageId){
        this.number = number;
        this.name = name;
        this.imageId = imageId;
    }

    public String getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
