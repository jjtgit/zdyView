package com.example.diyizzk190102.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.diyizzk190102.R;

import java.time.chrono.IsoChronology;

public class MainActivity extends AppCompatActivity {

    private GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        gv = (GridView) findViewById(R.id.gv);
    }
}
