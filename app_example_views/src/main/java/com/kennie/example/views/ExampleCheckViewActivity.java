package com.kennie.example.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kennie.views.checkbox.CheckView;

/**
 * 演示勾选(CheckView)
 */
public class ExampleCheckViewActivity extends AppCompatActivity implements View.OnClickListener, CheckView.OnCheckedChangeListener {

    private static String TAG = ExampleCheckViewActivity.class.getSimpleName();
    private CheckView checkView1, checkView2, checkView3, checkView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_check_view);
        checkView1 = findViewById(R.id.main_activity_check_view1);
        checkView2 = findViewById(R.id.main_activity_check_view2);
        checkView3 = findViewById(R.id.main_activity_check_view3);
        checkView4 = findViewById(R.id.main_activity_check_view4);

        checkView1.setOnClickListener(this);
        checkView2.setOnClickListener(this);
        checkView3.setOnClickListener(this);
        checkView4.setOnClickListener(this);

        setOnCheckedChangeListener(checkView1);
        setOnCheckedChangeListener(checkView2);
        setOnCheckedChangeListener(checkView3);
        setOnCheckedChangeListener(checkView4);

    }

    private void setOnCheckedChangeListener(CheckView checkView1) {
        checkView1.setOnCheckedChangeListener(this);
    }


    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.main_activity_check_view1) {
            checkView1.toggle(true);
        } else if (id == R.id.main_activity_check_view2) {
            checkView2.toggle(true);
        } else if (id == R.id.main_activity_check_view3) {
            checkView3.toggle();
        } else if (id == R.id.main_activity_check_view4) {
            checkView4.toggle(true);
        }

    }

    @Override
    public void onCheckedChanged(CheckView checkView, boolean isChecked) {
        Log.i(TAG, "checkViewId：" + checkView.getId() + " isChecked: " + isChecked);

    }
}