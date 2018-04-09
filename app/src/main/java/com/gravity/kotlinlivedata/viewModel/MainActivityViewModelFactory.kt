package com.gravity.kotlinlivedata.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.gravity.kotlinlivedata.repository.ApiServiceRepository
import javax.inject.Inject

/**
 * Created by Akash Verma on 09/04/18.
 */
class MainActivityViewModelFactory : ViewModelProvider.Factory {

    var apiServiceRepository: ApiServiceRepository

    @Inject
    constructor(apiServiceRepository: ApiServiceRepository) {
        this.apiServiceRepository = apiServiceRepository
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(apiServiceRepository = apiServiceRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}