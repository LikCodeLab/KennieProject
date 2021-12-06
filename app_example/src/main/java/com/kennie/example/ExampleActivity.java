package com.kennie.example;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class ExampleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        findViewById(R.id.iv_hangup).setOnClickListener(this);
        findViewById(R.id.iv_mute).setOnClickListener(this);
        findViewById(R.id.iv_handFree).setOnClickListener(this);
        findViewById(R.id.iv_video_handUp).setOnClickListener(this);
        CheckBox mDisableCamera = findViewById(R.id.cb_disable_camera);
        mDisableCamera.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                mDisableCamera.setText("开启摄像头");
            }else{
                mDisableCamera.setText("关闭摄像头");

            }
        });

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }
}