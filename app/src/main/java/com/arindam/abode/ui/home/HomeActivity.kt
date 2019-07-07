package com.arindam.abode.ui.home

import android.content.Intent
import android.os.Bundle
import com.arindam.abode.R
import com.arindam.abode.di.component.ActivityComponent
import com.arindam.abode.ui.base.BaseActivity
import com.arindam.abode.ui.write.WriteActivity
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

class HomeActivity: BaseActivity<HomeViewModel>() {

    override fun provideLayoutId() = R.layout.activity_home
    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {
        floatingActionButton.setOnClickListener { startActivity(Intent(this@HomeActivity, WriteActivity::class.java)) }
    }
}