package com.arindam.abode.di.module

import androidx.lifecycle.LifecycleRegistry
import com.arindam.abode.di.ViewModelScope
import com.arindam.abode.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

/**
 * Created by Arindam Karmakar on 2019-07-08.
 */

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}
