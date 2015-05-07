package com.example.catapp.ui;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.catapp.R;
import com.example.catapp.api.ApiImp;
import com.example.catapp.api.ApiWrapper;
import com.example.catapp.api.Callback;
import com.example.catapp.businessLogic.CatsHelper;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiWrapper apiWrapper = new ApiWrapper(new ApiImp());
        new CatsHelper(apiWrapper).saveTheCutestCat("some query", new Callback<Uri>() {
            @Override
            public void onResult(Uri result) {

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
