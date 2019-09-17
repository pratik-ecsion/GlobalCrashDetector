package com.example.globalcrashdetector;

import android.app.Application;

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashDetector.init();
    }
}
