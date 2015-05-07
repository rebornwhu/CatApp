package com.example.catapp.api;

import android.net.Uri;

import com.example.catapp.model.Cat;

import java.util.List;

/**
 * Created by xiao.lu on 5/6/15.
 */
public interface Api {
    interface CatsQueryCallback {
        void onCatListReceived(List<Cat> cats);
        void onQueryFailed(Exception e);
    }

    interface StoreCallback {
        void onCatStored(Uri uri);
        void onStoreFailed(Exception e);
    }

    void queryCats(String query, CatsQueryCallback catsQueryCallback);
    void store(Cat cat, StoreCallback storeCallback);
}