package com.hencoder.hencoderpracticedraw1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hencoder.hencoderpracticedraw1.practice.Practice12CirclePercentage;
import com.hencoder.hencoderpracticedraw1.practice.Practice13PercentLineView;
import com.meiji.hencoderstudy.practicedraw1.R;

/**
 * created by Meiji on 2018/6/1.
 */
public class MyViewActivity extends AppCompatActivity {

    private Practice12CirclePercentage circle;
    private Practice13PercentLineView line;
    private Practice13PercentLineView line2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myview);
        initView();
    }

    private void initView() {
        circle = findViewById(R.id.circle);
        circle.addItem(Color.RED, 1)
                .addItem(Color.BLUE, 1)
                .addItem(Color.GREEN, 2)
                .show();
        line = findViewById(R.id.line);
        line2 = findViewById(R.id.line2);
        line.setLinetColor(Color.BLACK);
        line2.setPercentage(0.2f);
    }
}
