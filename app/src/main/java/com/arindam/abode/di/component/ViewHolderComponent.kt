package com.arindam.abode.di.component

import com.arindam.abode.di.ViewModelScope
import com.arindam.abode.di.module.ViewHolderModule
import com.arindam.abode.ui.home.HomeItemViewHolder
import dagger.Component

/**
 * Created by Arindam Karmakar on 2019-07-08.
 */

@ViewModelScope
@Component(dependencies = [ApplicationComponent::class], modules = [ViewHolderModule::class])
interface ViewHolderComponent {

    fun inject(viewHolder: HomeItemViewHolder)
}
