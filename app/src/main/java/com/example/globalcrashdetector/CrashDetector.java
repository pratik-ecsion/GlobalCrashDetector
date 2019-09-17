package com.example.globalcrashdetector;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class CrashDetector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_detector);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public static void init() {
//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
//                Log.e("Alert","Lets See if it Works !!!");
//            }
//        });

        final Thread.UncaughtExceptionHandler oldHandler =
                Thread.getDefaultUncaughtExceptionHandler();

        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                        Log.d("TAG", "STARCK STARTCE  " + paramThread.getStackTrace());
                        Log.d("TAG", "LOCAL MESSAGE " + paramThrowable.getLocalizedMessage());
                        Log.d("TAG", " MESSAGE " + paramThrowable.getMessage());
                        Log.d("TAG", " CAUSE " + paramThrowable.getCause());
                        Log.d("TAG", " CAUSE " + paramThrowable.getStackTrace()[0]);
                        

                        //Do your own error handling here
                        Log.e("Alert", "Lets See if it Works !!!");
                        if (oldHandler != null)
                            oldHandler.uncaughtException(paramThread, paramThrowable); //Delegates to Android's error handling
                        else
                            System.exit(2); //Prevents the service/app from freezing

                    }
                });
    }

}
