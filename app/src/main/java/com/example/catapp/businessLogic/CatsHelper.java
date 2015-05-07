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

    public interface CutestCatCallback {
        void onCutestCatSaved(Uri uri);
        void onQueryFailed(Exception e);
    }

    public CatsHelper(Api api) {
        this.api = api;
    }

    public void saveTheCutestCat(String query, final CutestCatCallback cutestCatCallback) {
        api.queryCats(query, new Api.CatsQueryCallback() {
            @Override
            public void onCatListReceived(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                Log.i(TAG, cutest.toString());
                Uri savedUri = api.store(cutest);
                cutestCatCallback.onCutestCatSaved(savedUri);
            }

            @Override
            public void onError(Exception e) {
                cutestCatCallback.onQueryFailed(e);
            }
        });
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}