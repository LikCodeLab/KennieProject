package com.kennie.base.project.core;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @项目名 KennieProject
 * @类名称 BaseFragment
 * @类描述 Fragment基类
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/11/17 23:08
 */
public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;


    /**
     * 获取全局的context 防止使用getActivity()为空
     *
     * @param context 上下文
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(mActivity).inflate(getLayoutId(), container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view, savedInstanceState);
        initData();
    }

    protected abstract int getLayoutId();


    /**
     * initViews会在启动时首先执行，建议在此方法内进行布局绑定、View初始化等操作
     */
    public abstract void initView(View view, Bundle savedInstanceState);


    /**
     * initData 会在布局加载后执行，建议在此方法内加载数据和处理布局显示数据
     */
    public abstract void initData();
}
