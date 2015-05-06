package com.example.catapp.model;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;

/**
 * Created by xiao.lu on 5/6/15.
 */
public class Cat implements Comparable<Cat> {
    Bitmap image;
    int cuteness;

    @SuppressLint("NewApi")
    @Override
    public int compareTo(Cat another) {
        return Integer.compare(cuteness, another.cuteness);
    }
}
