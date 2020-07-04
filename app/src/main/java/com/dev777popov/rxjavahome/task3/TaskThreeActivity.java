package com.dev777popov.rxjavahome.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dev777popov.rxjavahome.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;

public class TaskThreeActivity extends AppCompatActivity {

    private static final String TAG = "TaskThreeActivity";

    private Observable<String> observable;
    private Single<String> single;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_three);
        ButterKnife.bind(this);
        RxPresenter rxPresenter = new RxPresenter();
        observable = rxPresenter.getPackageData();
        single = rxPresenter.getPackageDataSingle();
    }

    @OnClick(R.id.btnSubscribe)
    public void setSubscribeRx(View view) {
        disposable = observable
                .observeOn(mainThread())
                .subscribe(
                        string -> Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + string),
                        throwable -> Log.e(TAG, "onError: " + throwable),
                        () -> Log.d(TAG, "onComplete: "));

    }

    @OnClick(R.id.btnSubscribeSingle)
    public void setSubscribeSingleRx(View view) {
        disposable = single
                .observeOn(mainThread())
                .subscribe(
                        string -> Log.d(TAG, "onSuccess: " + Thread.currentThread().getName() + ": " + string),
                        throwable -> Log.e(TAG, "onError: " + throwable));
    }

    @OnClick(R.id.btnUnSubscribe)
    public void setUnSubscribeRx(View view) {
        disposable.dispose();
    }
}