package com.kennie.base.project.config;

/**
 * 路由相关配置
 * 用于组件开发中，ARouter跳转的统一路径注册
 */
public class RouterPath {

    /**
     * 主业务组件
     */
    public static class Main {
        private static final String MAIN = "/main";
        /* 主业务界面 */
        public static final String PAGER_MAIN = MAIN + "/Main";
        /* 启动闪屏界面 */
        public static final String PAGER_SPLASH = MAIN + "/splash";
    }


    //************************** 主功能模块 ****************************/

    /**
     * 首页模块
     */
    public static class Home {
        private static final String HOME = "/home";
        /* 首页 */
        public static final String PAGER_HOME = HOME + "/Home";
    }


    /**
     * 消息模块
     */
    public static class Msg {
        private static final String MSG = "/msg";
        /* 消息 */
        public static final String PAGER_MSG = MSG + "/Msg";
    }

    /**
     * 用户模块
     */
    public static class User {
        private static final String USER = "/user";
        /* 用户界面 */
        public static final String PAGER_USER = USER + "/User";
    }

    //************************** 子功能模块 ****************************/

    /**
     * 身份验证组件
     */
    public static class Login {
        private static final String LOGIN = "/login";
        /* 登录界面 */
        public static final String PAGER_LOGIN = LOGIN + "/Login";
    }


}
