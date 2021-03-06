package com.example.catapp.api;

import android.net.Uri;

import com.example.catapp.async.AsyncJob;
import com.example.catapp.model.Cat;

import java.util.List;

/**
 * Created by xiao.lu on 5/6/15.
 */
public class ApiWrapper {
    Api api;

    public ApiWrapper(Api api) {
        this.api = api;
    }

    public AsyncJob<List<Cat>> queryCats(final String query) {
        return new AsyncJob<List<Cat>>() {
            @Override
            public void start(final Callback<List<Cat>> catsCallback) {
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
        };
    }

    public AsyncJob<Uri> store(final Cat cat) {
        return new AsyncJob<Uri>() {
            @Override
            public void start(final Callback<Uri> uriCallback) {
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
        };
    }
}
