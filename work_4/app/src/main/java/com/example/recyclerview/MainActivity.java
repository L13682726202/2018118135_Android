package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Animal> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("十二生肖");

        initAnimals();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        AnimalAdapter adapter = new AnimalAdapter(animalList);
        recyclerView.setAdapter(adapter);
    }

    private void initAnimals(){
        for(int i = 0; i < 2; i++){
            Animal mouse = new Animal(getRandomLengthName("鼠"), R.drawable.mouse);
            animalList.add(mouse);
            Animal cattle = new Animal(getRandomLengthName("牛"), R.drawable.cattle);
            animalList.add(cattle);
            Animal tiger = new Animal(getRandomLengthName("虎"), R.drawable.tiger);
            animalList.add(tiger);
            Animal rabbit = new Animal(getRandomLengthName("兔"), R.drawable.rabbit);
            animalList.add(rabbit);
            Animal dragon = new Animal(getRandomLengthName("龙"), R.drawable.dragon);
            animalList.add(dragon);
            Animal snake = new Animal(getRandomLengthName("蛇"), R.drawable.snake);
            animalList.add(snake);
            Animal horse = new Animal(getRandomLengthName("马"), R.drawable.horse);
            animalList.add(horse);
            Animal sheep = new Animal(getRandomLengthName("羊"), R.drawable.sheep);
            animalList.add(sheep);
            Animal monkey = new Animal(getRandomLengthName("猴"), R.drawable.monkey);
            animalList.add(monkey);
            Animal chicken = new Animal(getRandomLengthName("鸡"), R.drawable.chicken);
            animalList.add(chicken);
            Animal dog = new Animal(getRandomLengthName("狗"), R.drawable.dog);
            animalList.add(dog);
            Animal pig = new Animal(getRandomLengthName("猪"), R.drawable.pig);
            animalList.add(pig);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(50) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i++){
            builder.append(name);
        }
        return builder.toString();
    }
}