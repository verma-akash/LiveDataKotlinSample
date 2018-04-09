package com.gravity.kotlinlivedata.di.modules

import com.gravity.kotlinlivedata.repository.ApiServiceHelper
import com.gravity.kotlinlivedata.di.scopes.ApplicationScope
import com.gravity.kotlinlivedata.repository.ApiServiceRepository
import com.gravity.kotlinlivedata.viewModel.MainActivityViewModelFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Akash Verma on 18/03/18.
 */

@Module(includes = [(NetworkModule::class)])
class ApiServiceHelperModule {

    @Provides
    @ApplicationScope
    fun getAppServiceHelper(retrofit: Retrofit): ApiServiceHelper {
        return retrofit.create(ApiServiceHelper::class.java)
    }

    @Provides
    @ApplicationScope
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.github.com/users/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @ApplicationScope
    fun providesMainActivityViewModelFactory(apiServiceRepository: ApiServiceRepository): MainActivityViewModelFactory {
        return MainActivityViewModelFactory(apiServiceRepository)
    }

    @Provides
    @ApplicationScope
    fun providesApiServiceRepository(): ApiServiceRepository {
        return ApiServiceRepository()
    }
}