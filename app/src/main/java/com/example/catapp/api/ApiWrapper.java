package com.example.catapp.api;

import android.net.Uri;

import com.example.catapp.model.Cat;

import java.util.List;

/**
 * Created by xiao.lu on 5/6/15.
 */
public class ApiWrapper {
    Api api;

    public void queryCat(String query, final Callback<List<Cat>> catsCallback) {
        api.queryCats(query, new Api.CatsQueryCallback() {
            @Override
            public void onCatListReceived(List<Cat> cats) {
                catsCallback.onResult(cats);
            }

            @Override
            public void onQueryFailed(Exception e) {
                catsCallback.onError(e);
            }
        });
    }

    public void store(Cat cat, final Callback<Uri> uriCallback) {
        api.store(cat, new Api.StoreCallback() {
            @Override
            public void onCatStored(Uri uri) {
                uriCallback.onResult(uri);
            }

            @Override
            public void onStoreFailed(Exception e) {
                uriCallback.onError(e);
            }
        });
    }
}
