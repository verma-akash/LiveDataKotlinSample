package com.gravity.kotlinlivedata.di.components

import com.gravity.kotlinlivedata.di.modules.ActivityContextModule
import com.gravity.kotlinlivedata.di.scopes.ActivityScope
import com.gravity.kotlinlivedata.repository.ApiServiceRepository
import com.gravity.kotlinlivedata.view.MainActivity
import com.gravity.kotlinlivedata.viewModel.MainActivityViewModel
import com.gravity.kotlinlivedata.viewModel.MainActivityViewModelFactory
import dagger.Component

/**
 * Created by Akash Verma on 19/03/18.
 */

@ActivityScope
@Component(dependencies = [(ApplicationComponent::class)], modules = [ActivityContextModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(mainActivityViewModelFactory: MainActivityViewModelFactory)

    fun inject(apiServiceRepository: ApiServiceRepository)

    fun inject(mainActivityViewModel: MainActivityViewModel)
}