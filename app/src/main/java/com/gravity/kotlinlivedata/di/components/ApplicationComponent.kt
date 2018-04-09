package com.gravity.kotlinlivedata.di.components

import com.bumptech.glide.RequestManager
import com.gravity.kotlinlivedata.repository.ApiServiceHelper
import com.gravity.kotlinlivedata.di.modules.ApiServiceHelperModule
import com.gravity.kotlinlivedata.di.modules.GlideModule
import com.gravity.kotlinlivedata.di.scopes.ApplicationScope
import dagger.Component

/**
 * Created by Akash Verma on 18/03/18.
 */
@ApplicationScope
@Component(modules = [(ApiServiceHelperModule::class), (GlideModule::class)])
interface ApplicationComponent {

    fun getApiServiceHelper(): ApiServiceHelper

    fun getGlideRequestManager(): RequestManager

}