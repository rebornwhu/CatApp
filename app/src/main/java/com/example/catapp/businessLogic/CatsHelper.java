package com.example.catapp.businessLogic;

import android.net.Uri;
import android.util.Log;

import com.example.catapp.api.ApiWrapper;
import com.example.catapp.api.Callback;
import com.example.catapp.async.AsyncJob;
import com.example.catapp.async.Func;
import com.example.catapp.model.Cat;

import java.util.Collections;
import java.util.List;

/**
 * Created by xiao.lu on 5/6/15.
 */
public class CatsHelper {
    private static final String TAG = "CatsHelper";

    ApiWrapper apiWrapper;


    public CatsHelper(ApiWrapper apiWrapper) {
        this.apiWrapper = apiWrapper;
    }

    public AsyncJob<Uri> saveTheCutestCat(String query, Callback<Uri> uriCallback) {
        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                Cat cutestCat = findCutest(cats);
                Log.i(TAG, cutestCat.toString());
                return cutestCat;
            }
        });

        AsyncJob<Uri> storedUriAsyncJob = cutestCatAsyncJob.flatMap(new Func<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> call(Cat cat) {
                return apiWrapper.store(cat);
            }
        });
        return storedUriAsyncJob;
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}