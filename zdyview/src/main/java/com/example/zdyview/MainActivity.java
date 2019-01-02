package com.example.zdyview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MyView mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mv=findViewById(R.id.mv);
        mv.invalidate();//在主线程
        mv.postInvalidate();//在子线程
    }
}
