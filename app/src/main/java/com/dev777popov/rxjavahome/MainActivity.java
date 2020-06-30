package com.dev777popov.rxjavahome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dev777popov.rxjavahome.task1.ActivityForAsync;
import com.dev777popov.rxjavahome.task2.TaskTwoActivity;
import com.dev777popov.rxjavahome.task3.TaskThreeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTask1(View view) {
        startActivity(new Intent(this, ActivityForAsync.class));
    }

    public void startTask2(View view) {
        startActivity(new Intent(this, TaskTwoActivity.class));
    }

    public void startTask3(View view) {
        startActivity(new Intent(this, TaskThreeActivity.class));
    }
}