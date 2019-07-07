package com.arindam.abode.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.arindam.abode.TaskApplication
import com.arindam.abode.di.component.ActivityComponent
import com.arindam.abode.di.component.DaggerActivityComponent
import com.arindam.abode.di.module.ActivityModule
import javax.inject.Inject

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())

        setupObservers()
        setupView(savedInstanceState)
    }

    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as TaskApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

    protected open fun setupObservers() {}

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)
}
