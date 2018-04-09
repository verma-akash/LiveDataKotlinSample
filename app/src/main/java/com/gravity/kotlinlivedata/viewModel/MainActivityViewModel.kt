package com.gravity.kotlinlivedata.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.gravity.kotlinlivedata.model.FollowersProfile
import com.gravity.kotlinlivedata.repository.ApiServiceRepository
import javax.inject.Inject

/**
 * Created by Akash Verma on 05/04/18.
 */
class MainActivityViewModel constructor() : ViewModel() {

    lateinit var apiServiceRepository: ApiServiceRepository

    private lateinit var followersListObservable: LiveData<List<FollowersProfile>>

    @Inject
    constructor(apiServiceRepository: ApiServiceRepository) : this() {
        this.apiServiceRepository = apiServiceRepository
    }

    fun getFollowersListObservable(): LiveData<List<FollowersProfile>> {
        return followersListObservable
    }

    fun loadFollowers(userName: String) {
        followersListObservable = apiServiceRepository.getFollowersList(userName)
    }
}