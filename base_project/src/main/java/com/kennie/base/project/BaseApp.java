package com.kennie.base.project;

import android.app.Application;

/**
 * @项目名 KennieProject
 * @类名称 BaseApp
 * @类描述
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/11/17 23:18
 */
public abstract class BaseApp<ProjectApp extends BaseApp> extends Application {

    public ProjectApp projectApp;
    private static Application instance;

    public static <App extends BaseApp> App getInstance(Class<App> appClass) {
        return (App) instance;
    }

    public abstract void init();

    @Override
    public void onCreate() {
        super.onCreate();
        projectApp = (ProjectApp) this;
        instance = projectApp;
        init();
    }

    /**
     * 此方法用于主动设置实例化 application 对象以实现一些需要 context 的场合下不需要传参，减少工作量，
     * 在您有实现 App extends BaseApp 的情况下无需调用，
     * 请勿手动调用此方法，此接口仅用于 BaseActivity 以固定逻辑调用。
     *
     * @param context Application 上下文
     * @hide
     */
    public static void setPrivateInstance(Application context) {
        BaseApp.instance = context;
    }

    /**
     * 此方法用于主动获取实例化的 application 对象以实现一些需要 context 的场合下不需要传参，减少工作量，
     * 如需要使用 App 的实例化对象，请勿使用本方法，
     * 请自行实现 getInstance() 方法，或使用 {@link #getInstance(Class)} 来获取。
     *
     * @return 例化的 application 对象
     */
    public static Application getPrivateInstance() {
        if (instance == null) {
            return null;
        }

        return instance;
    }
}
