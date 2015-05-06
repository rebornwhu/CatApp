package com.example.catapp.businessLogic;

import android.net.Uri;
import android.util.Log;

import com.example.catapp.api.Api;
import com.example.catapp.model.Cat;

import java.util.Collections;
import java.util.List;

/**
 * Created by xiao.lu on 5/6/15.
 */
public class CatsHelper {
    private static final String TAG = "CatsHelper";
    Api api;

    public CatsHelper(Api api) {
        this.api = api;
    }

    public Uri saveTheCutestCat(String query) {
        List<Cat> cats = api.queryCats(query);
        Cat cutest = findCutest(cats);
        Log.i(TAG, cutest.toString());
        Uri savedUri = api.store(cutest);
        return savedUri;
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
