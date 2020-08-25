package com.example.recyclercard;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ApplicationClass  extends Application {
    public  static ArrayList<Person>  people;

    @Override
    public void onCreate() {
        super.onCreate();
        people= new ArrayList<>();
        people.add(new Person("ankit","99837424923023"));
        people.add(new Person("shyam","9983742400023023"));
        people.add(new Person("ram","99837424954343"));
        people.add(new Person("ankit","99837424923023"));
        people.add(new Person("rahul","998364923023"));
    }
}
