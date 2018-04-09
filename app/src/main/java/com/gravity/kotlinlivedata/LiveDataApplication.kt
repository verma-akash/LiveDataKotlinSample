package com.gravity.kotlinlivedata

import android.app.Activity
import android.app.Application
import com.gravity.kotlinlivedata.di.components.ApplicationComponent
import com.gravity.kotlinlivedata.di.components.DaggerApplicationComponent
import com.gravity.kotlinlivedata.di.modules.ContextModule


/**
 * Created by Akash Verma on 18/03/18.
 */
class LiveDataApplication : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    companion object {
        fun get(activity: Activity): LiveDataApplication {
            return activity.application as LiveDataApplication
        }
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(ContextModule(this))
                .build()

    }

    fun getComponent(): ApplicationComponent {
        return applicationComponent
    }
}