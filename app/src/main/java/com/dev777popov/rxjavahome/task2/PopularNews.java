package com.dev777popov.rxjavahome.task2;

import android.util.Log;

import java.util.ArrayList;

public class PopularNews implements Observable {

    private static final String TAG = "PopularNews";

    private ArrayList<Observer> arrayList;
    private String name;
    private String num;

    public PopularNews(){
        arrayList = new ArrayList<>();
    }

    public void newPost(String name, String num){
        this.name = name;
        this.num = num;
        notifyAllObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        Log.d(TAG, "registerObserver: ");
        arrayList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        Log.d(TAG, "unregisterObserver: ");
        arrayList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        Log.d(TAG, "notifyAllObservers: ");
        for (int i = 0; i < arrayList.size(); i++) {
            Observer observer = arrayList.get(i);
            observer.updateData(name, num);
        }
    }
}
