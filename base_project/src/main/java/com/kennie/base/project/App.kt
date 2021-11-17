package com.kennie.base.project

import android.app.Application

/**
 * @项目名 KennieProject
 * @类名称 App
 * @类描述
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/11/17 23:17
 */
open class App : Application() {

    companion object {
        private lateinit var app: App

        // @JvmStatic 加上后可以直接 getInstance()，不然需要加上Companion
        @JvmStatic
        fun getInstance(): App {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this

    }
}