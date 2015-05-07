package com.example.catapp.api;

/**
 * Created by xiao.lu on 5/6/15.
 */
public interface Callback<T> {
    void onResult(T result);
    void onError(Exception e);
}
