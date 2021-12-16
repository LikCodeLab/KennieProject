package com.kennie.example.project;


import com.alibaba.android.arouter.launcher.ARouter;
import com.kennie.base.project.app.IApplication;


/**
 * @项目名 KennieProject
 * @类名称 ProjectApplication
 * @类描述 项目Application
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/12/9 23:00
 */
public class ProjectApplication extends IApplication {

    @Override
    public void onCreate() {
        super.onCreate();


    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
