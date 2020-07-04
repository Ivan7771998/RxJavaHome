package com.dev777popov.rxjavahome.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dev777popov.rxjavahome.R;

public class ActivityForAsync extends AppCompatActivity {

    public static final String TAG = "ActivityForAsync";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_async);
    }

    public void onClickBtn(View view) {
        new MyAsyncTask().execute();
        Log.d(TAG, "clickBtn: " + Thread.currentThread().getName());
    }
}