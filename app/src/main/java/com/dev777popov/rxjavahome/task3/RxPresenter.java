package com.dev777popov.rxjavahome.task3;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class RxPresenter {

    private static final String TAG = "RxPresenter";

    public Observable<String> getPackageData() {

        return Observable.create((ObservableOnSubscribe<String>) emitter -> {
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
        }).subscribeOn(Schedulers.io());
    }

    public Single<String> getPackageDataSingle() {
        return Single.create((SingleOnSubscribe<String>) emitter -> {
            String data = "data: " + 1;
            Log.d(TAG, "getPackageDataSingle: " + Thread.currentThread().getName() + ": " + data);
            emitter.onSuccess(data);
        }).subscribeOn(Schedulers.io());
    }
}
