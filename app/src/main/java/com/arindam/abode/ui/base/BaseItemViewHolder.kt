package com.arindam.abode.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import com.arindam.abode.TaskApplication
import com.arindam.abode.di.component.DaggerViewHolderComponent
import com.arindam.abode.di.component.ViewHolderComponent
import com.arindam.abode.di.module.ViewHolderModule
import javax.inject.Inject

/**
 * Created by Arindam Karmakar on 2019-07-08.
 */

abstract class BaseItemViewHolder<T : Any, VM : BaseItemViewModel<T>>(
    @LayoutRes layoutId: Int, parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
), LifecycleOwner {

    init {
        onCreate()
    }

    @Inject
    lateinit var viewModel: VM
    @Inject
    lateinit var lifecycleRegistry: LifecycleRegistry

    override fun getLifecycle(): Lifecycle = lifecycleRegistry
    open fun bind(data: T) {
        viewModel.updateData(data)
    }

    protected fun onCreate() {
        injectDependencies(buildViewHolderComponent())
        lifecycleRegistry.markState(Lifecycle.State.INITIALIZED)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        setupObservers()
    }

    fun onStart() {
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    fun onStop() {
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
    }

    fun onDestroy() {
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    private fun buildViewHolderComponent() =
        DaggerViewHolderComponent
            .builder()
            .applicationComponent((itemView.context.applicationContext as TaskApplication).applicationComponent)
            .viewHolderModule(ViewHolderModule(this))
            .build()

    protected abstract fun injectDependencies(viewHolderComponent: ViewHolderComponent)
    protected open fun setupObservers() {}
    abstract fun setupView(view: View)
}
