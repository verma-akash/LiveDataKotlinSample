package com.gravity.kotlinlivedata.repository

import com.gravity.kotlinlivedata.model.FollowersProfile
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.ArrayList

/**
 * Created by Akash Verma on 18/03/18.
 */
interface ApiServiceHelper {

    @GET("{userName}/followers")
    fun getFollowers(@Path("userName") userName: String): Call<ArrayList<FollowersProfile>>
}

