package com.gravity.kotlinlivedata.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gravity.kotlinlivedata.LiveDataApplication
import com.gravity.kotlinlivedata.di.components.ActivityComponent
import com.gravity.kotlinlivedata.di.components.DaggerActivityComponent
import com.gravity.kotlinlivedata.di.modules.ActivityContextModule

/**
 * Created by Akash Verma on 18/03/18.
 */
abstract class BaseActivity : AppCompatActivity() {

    private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = DaggerActivityComponent.builder()
                .activityContextModule(ActivityContextModule(this))
                .applicationComponent(LiveDataApplication.get(this).getComponent())
                .build()

    }

    fun getActivityComponent(): ActivityComponent {
        return activityComponent
    }
}