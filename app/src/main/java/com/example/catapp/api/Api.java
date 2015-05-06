package com.example.catapp.api;

import android.net.Uri;

import com.example.catapp.model.Cat;

import java.util.List;

/**
 * Created by xiao.lu on 5/6/15.
 */
public interface Api {
    List<Cat> queryCats(String query);
    Uri store(Cat cat);
}
