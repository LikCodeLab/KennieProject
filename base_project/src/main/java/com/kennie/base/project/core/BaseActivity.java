package com.kennie.base.project.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kennie.base.project.core.action.ActivityAction;
import com.kennie.base.project.core.action.HandlerAction;

/**
 * @项目名 KennieProject
 * @类名称 BaseActivity
 * @类描述 Activity基类
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/11/17 21:28
 */
public abstract class BaseActivity extends AppCompatActivity implements ActivityAction, HandlerAction {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();
        initView();
        initData();
    }


    /**
     * 初始化布局
     */
    protected void initLayout() {
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
    }

    public abstract int getLayoutId();

    /**
     * initView会在启动时首先执行，建议在此方法内进行布局绑定、View初始化等操作
     */
    public abstract void initView();


    /**
     * initData 会在布局加载后执行，建议在此方法内加载数据和处理布局显示数据
     */
    public abstract void initData();


    /**
     * 如果当前的 Activity（singleTop 启动模式） 被复用时会回调
     *
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // 设置为当前的 Intent，避免 Activity 被杀死后重启 Intent 还是最原先的那个
        setIntent(intent);
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeCallbacks();
    }

}
