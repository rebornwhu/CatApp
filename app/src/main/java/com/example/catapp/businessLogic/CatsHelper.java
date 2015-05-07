package com.example.catapp.businessLogic;

import android.net.Uri;
import android.util.Log;

import com.example.catapp.api.ApiWrapper;
import com.example.catapp.api.Callback;
import com.example.catapp.model.Cat;

import java.util.Collections;
import java.util.List;

/**
 * Created by xiao.lu on 5/6/15.
 */
public class CatsHelper {
    private static final String TAG = "CatsHelper";

    ApiWrapper apiWrapper;

    public interface CutestCatCallback {
        void onCutestCatSaved(Uri uri);
        void onError(Exception e);
    }

    public CatsHelper(ApiWrapper apiWrapper) {
        this.apiWrapper = apiWrapper;
    }

    public void saveTheCutestCat(String query, final Callback<Uri> cutestCatCallback){
        apiWrapper.queryCats(query, new Callback<List<Cat>>() {
            @Override
            public void onResult(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                Log.i(TAG, cutest.toString());
                apiWrapper.store(cutest, cutestCatCallback);
            }

            @Override
            public void onError(Exception e) {
                cutestCatCallback.onError(e);
            }
        });
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}