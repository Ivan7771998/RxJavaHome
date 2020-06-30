package com.dev777popov.rxjavahome.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.dev777popov.rxjavahome.R;

public class TaskTwoActivity extends AppCompatActivity {

    private PopularNews popularNews;
    private Subscriber subscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);
        popularNews = new PopularNews();
        subscriber = new Subscriber();
    }
    public void setSubscribe(View view) {
        popularNews.registerObserver(subscriber);
    }

    public void setUnSubscribe(View view) {
        popularNews.unregisterObserver(subscriber);
    }

    public void sendSpam(View view) {
        popularNews.newPost("Spam", "777");
    }
}