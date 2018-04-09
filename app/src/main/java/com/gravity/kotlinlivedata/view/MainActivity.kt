package com.gravity.kotlinlivedata.view

import android.app.AlertDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import com.gravity.kotlinlivedata.R
import com.gravity.kotlinlivedata.model.FollowersProfile
import com.gravity.kotlinlivedata.viewModel.MainActivityViewModel
import com.gravity.kotlinlivedata.viewModel.MainActivityViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var profileAdapter: ProfileAdapter

    @Inject
    lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory

    private val followersProfileArrayList = ArrayList<FollowersProfile>()

    private var mainActivityViewModel: MainActivityViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getActivityComponent().inject(this)

        mainActivityViewModel = ViewModelProviders.of(this, mainActivityViewModelFactory).get(MainActivityViewModel::class.java)

        profileAdapter.setFollowersProfileArrayList(followersProfileArrayList)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = profileAdapter

        showDialog()
    }

    private fun observeViewModel() {
        mainActivityViewModel!!.getFollowersListObservable().observe(this, Observer {
            if (it != null){
                initializeData(it)
                showMainContainer()
            }
            else
                showErrorMsg()

            hideLoading()
        })
    }

    private fun showDialog() {
        val li = LayoutInflater.from(this)
        val promptsView = li.inflate(R.layout.user_dialog, null)

        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setView(promptsView)
        val userInput = promptsView.findViewById(R.id.user_name_et) as EditText

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK"
                ) { _, _ ->
                    showLoading()
                    mainActivityViewModel!!.loadFollowers(userInput.text.toString())
                    observeViewModel()
                }
                .setNegativeButton("Cancel"
                ) { dialog, _ -> dialog.cancel() }

        val alertDialog = alertDialogBuilder.create()

        alertDialog.show()
    }

    private fun initializeData(followersProfileArrayList: List<FollowersProfile>) {
        mainContainer.visibility = View.VISIBLE
        errorMsg.visibility = View.GONE
        this.followersProfileArrayList.clear()
        this.followersProfileArrayList.addAll(followersProfileArrayList)
        profileAdapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId) {
            R.id.change_user -> {
                showDialog()
                true
            }
            else -> {
                false
            }
        }
    }

    private fun showErrorMsg() {
        errorMsg.visibility = View.VISIBLE
    }

    private fun hideErrorMsg() {
        errorMsg.visibility = View.GONE
    }

    private fun showMainContainer() {
        mainContainer.visibility = View.VISIBLE
    }

    private fun hideMainContainer() {
        mainContainer.visibility = View.GONE
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
        hideMainContainer()
        hideErrorMsg()
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
    }
}
