package com.kennie.module.main.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.kennie.base.project.ProjectActivity;
import com.kennie.base.project.config.RouterPath;
import com.kennie.module.main.BuildConfig;
import com.kennie.module.main.R;
import com.kennie.module.main.databinding.ActSplashBinding;

/**
 * App启动页
 */
@Route(path = RouterPath.Main.PAGER_MAIN)
public class SplashActivity extends ProjectActivity {

    private ActSplashBinding actSplashBinding;

    @Override
    public int getLayoutId() {
        return R.layout.act_splash;
    }

    @Override
    public void initData() {
        super.initData();
        actSplashBinding.ivSplashLottie.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                actSplashBinding.ivSplashLottie.removeAnimatorListener(this);
            }
        });
        actSplashBinding.tvSplashVersion.setText(BuildConfig.BUILD_TYPE.toLowerCase());
        if (BuildConfig.DEBUG) {
            actSplashBinding.tvSplashVersion.setVisibility(View.VISIBLE);

        } else {
            actSplashBinding.tvSplashVersion.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        //禁用返回键
    }
}
