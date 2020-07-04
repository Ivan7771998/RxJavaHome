package com.dev777popov.rxjavahome.task3;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class RxPresenter {

    private static final String TAG = "RxPresenter";

    public Observable<String> getPackageData() {

        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) {
                try {
                    for (int i = 0; i < 10; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        String data = "data: " + i;
                        Log.d(TAG, "getPackageData: " + Thread.currentThread().getName() + ": " + data);
                        emitter.onNext(data);
                    }
                } catch (InterruptedException e) {
                    Log.d(TAG, "getPackageData: unsubscribed");
                }
            }
        }).subscribeOn(Schedulers.io());
    }
}
