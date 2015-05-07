package com.example.catapp.api;

import android.net.Uri;

import com.example.catapp.model.Cat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiao.lu on 5/6/15.
 */
public class ApiImp implements Api {

    @Override
    public void queryCats(String query, CatsQueryCallback catsQueryCallback) {
        try {
            List<Cat> list = queryCats(query);
            catsQueryCallback.onCatListReceived(list);
        } catch (Exception e) {
            catsQueryCallback.onError(e);
        }
    }

    @Override
    public Uri store(Cat cat) {
        sleep(1500);
        return null;
    }

    private List<Cat> queryCats(String query) {
        sleep(3000);
        ArrayList<Cat> list = new ArrayList<Cat>();
        list.add(new Cat("Grumpy Cat", 10));
        list.add(new Cat("Bella", 9));
        list.add(new Cat("Smokey", 8));
        list.add(new Cat("Whiskers", 7));
        return list;
    }

    private static void sleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        }
        catch (Exception e) { };
    }
}
