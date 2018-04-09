package com.gravity.kotlinlivedata.di.modules

import com.gravity.kotlinlivedata.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Akash Verma on 18/03/18.
 */
@Module
class NetworkModule {
    @Provides
    @ApplicationScope
    fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    @Provides
    @ApplicationScope
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {

        })
    }
}