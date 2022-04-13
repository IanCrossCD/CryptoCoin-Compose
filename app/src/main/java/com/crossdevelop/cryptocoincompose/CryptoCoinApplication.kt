package com.crossdevelop.cryptocoincompose

import android.app.Application


class CryptoCoinApplication : Application() {

    // AppContainer instance used by the rest of classes to obtain dependencies
//    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
//        container = AppContainerImpl(this)
    }
}