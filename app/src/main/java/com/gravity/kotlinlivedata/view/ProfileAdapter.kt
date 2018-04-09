package com.gravity.kotlinlivedata.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.RequestManager
import com.gravity.kotlinlivedata.R
import com.gravity.kotlinlivedata.di.qualifiers.ActivityQualifier
import com.gravity.kotlinlivedata.model.FollowersProfile
import java.util.ArrayList
import javax.inject.Inject
import kotlinx.android.synthetic.main.single_profile_holder.view.*

/**
 * Created by Akash Verma on 20/03/18.
 */
class ProfileAdapter @Inject constructor(@ActivityQualifier context: BaseActivity, private val glide: RequestManager) : RecyclerView.Adapter<ProfileAdapter.ProfileHolder>() {

    private val context: Context = context
    private var followersProfileArrayList: ArrayList<FollowersProfile>? = null

    fun setFollowersProfileArrayList(followersProfileArrayList: ArrayList<FollowersProfile>) {
        this.followersProfileArrayList = followersProfileArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_profile_holder, parent, false)
        return ProfileHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
        glide.load(followersProfileArrayList!![position].avatarUrl)
                .into(holder.profilePic)
        holder.profileId!!.text = followersProfileArrayList!![position].login
    }

    override fun getItemCount(): Int {
        return followersProfileArrayList!!.size
    }

    inner class ProfileHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var profilePic: ImageView? = null
        var profileId: TextView? = null

        init {
            this.profileId = itemView.profileId
            this.profilePic = itemView.profilePic
        }
    }
}