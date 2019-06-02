package com.yuliyang.navigator

import android.app.Application
import kotlin.properties.Delegates

class MyApplication : Application() {

    companion object {
        var instance: Application by Delegates.notNull()

        fun provideInstance(): Application {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}