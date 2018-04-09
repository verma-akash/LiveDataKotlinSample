package com.gravity.kotlinlivedata.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.gravity.kotlinlivedata.model.FollowersProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Akash Verma on 05/04/18.
 */
class ApiServiceRepository @Inject constructor() {

    @Inject
    lateinit var apiServiceHelper: ApiServiceHelper

    fun getFollowersList(userName: String): LiveData<List<FollowersProfile>> {

        val data = MutableLiveData<List<FollowersProfile>>()

        apiServiceHelper.getFollowers(userName).enqueue(object : Callback<ArrayList<FollowersProfile>> {

            override fun onResponse(call: Call<ArrayList<FollowersProfile>>?, response: Response<ArrayList<FollowersProfile>>?) {
                data.value = response!!.body()
            }

            override fun onFailure(call: Call<ArrayList<FollowersProfile>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        return data
    }
}