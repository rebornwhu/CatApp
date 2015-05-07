package com.example.catapp.ui;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.catapp.R;
import com.example.catapp.api.ApiImp;
import com.example.catapp.businessLogic.CatsHelper;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiImp api = new ApiImp();
        new CatsHelper(api).saveTheCutestCat("some query", new CatsHelper.CutestCatCallback() {
            @Override
            public void onCutestCatSaved(Uri uri) {

            }

            @Override
            public void onQueryFailed(Exception e) {

            }
        });
    }
}
