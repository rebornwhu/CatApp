package com.example.catapp.async;

/**
 * Created by xiao.lu on 5/8/15.
 */
public interface Func<T, R> {
    R call (T t);
}
