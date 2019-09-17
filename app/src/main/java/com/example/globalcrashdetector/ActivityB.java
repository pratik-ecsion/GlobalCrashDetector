package com.example.globalcrashdetector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        //int a=1/0;
        data = data.substring(0, 10);
    }
}
