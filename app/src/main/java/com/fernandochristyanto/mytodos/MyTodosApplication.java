package com.fernandochristyanto.mytodos;

import android.app.Application;

import timber.log.Timber;

public class MyTodosApplication extends Application {
    @Override
    public void onCreate () {
        super.onCreate();
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }
}
