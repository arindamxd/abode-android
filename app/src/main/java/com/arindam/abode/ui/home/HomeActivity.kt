package com.arindam.abode.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arindam.abode.R
import com.arindam.abode.di.component.ActivityComponent
import com.arindam.abode.ui.base.BaseActivity
import com.arindam.abode.ui.write.WriteActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

class HomeActivity : BaseActivity<HomeViewModel>() {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager
    @Inject
    lateinit var homeAdapter: HomeAdapter

    override fun provideLayoutId() = R.layout.activity_home
    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupObservers() {
        super.setupObservers()

        viewModel.getNotesData().observe(this, Observer { homeAdapter.appendData(ArrayList(it)) })
    }

    override fun setupView(savedInstanceState: Bundle?) {
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = homeAdapter

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, WriteActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.fetchDataList()
    }
}