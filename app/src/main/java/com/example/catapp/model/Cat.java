package com.example.catapp.model;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;

/**
 * Created by xiao.lu on 5/6/15.
 */
public class Cat implements Comparable<Cat> {
    String name;
    Bitmap image;
    int cuteness;

    public Cat(String name, int cuteness) {
        this.name = name;
        this.cuteness = cuteness;
    }

    @SuppressLint("NewApi")
    @Override
    public int compareTo(Cat another) {
        return Integer.compare(cuteness, another.cuteness);
    }

    @Override
    public String toString() {
        return "<" + name + ": " + cuteness + ">";
    }
}
