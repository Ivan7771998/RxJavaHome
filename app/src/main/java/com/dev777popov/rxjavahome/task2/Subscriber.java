package com.dev777popov.rxjavahome.task2;

import android.util.Log;

public class Subscriber implements Observer {

    private static final String TAG = "Subscriber";

    @Override
    public void updateData(String name, String num) {
        Log.d(TAG, "show spam: " + name + " number: " + num);
    }
}
