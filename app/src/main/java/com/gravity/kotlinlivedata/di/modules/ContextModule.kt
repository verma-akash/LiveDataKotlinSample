package com.gravity.kotlinlivedata.di.modules

import android.content.Context
import com.gravity.kotlinlivedata.di.qualifiers.ApplicationContext
import com.gravity.kotlinlivedata.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Akash Verma on 20/03/18.
 */

@Module
class ContextModule {

    private val context: Context

    constructor(context: Context) {
        this.context = context
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun providesApplicationContext(): Context {
        return context
    }
}