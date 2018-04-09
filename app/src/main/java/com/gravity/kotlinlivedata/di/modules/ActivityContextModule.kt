package com.gravity.kotlinlivedata.di.modules

import com.gravity.kotlinlivedata.di.qualifiers.ActivityQualifier
import com.gravity.kotlinlivedata.di.scopes.ActivityScope
import com.gravity.kotlinlivedata.view.BaseActivity
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akash Verma on 19/03/18.
 */
@Module
class ActivityContextModule {

    private val context: BaseActivity

    constructor(context: BaseActivity) {
        this.context = context
    }

    @Provides
    @ActivityScope
    fun getCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @ActivityScope
    @ActivityQualifier
    fun providesActivityContext(): BaseActivity {
        return context
    }
}