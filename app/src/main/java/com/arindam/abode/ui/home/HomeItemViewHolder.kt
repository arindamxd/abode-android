package com.arindam.abode.ui.home

import android.util.Log
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.arindam.abode.R
import com.arindam.abode.data.db.entity.NoteEntity
import com.arindam.abode.di.component.ViewHolderComponent
import com.arindam.abode.ui.base.BaseItemViewHolder

/**
 * Created by Arindam Karmakar on 2019-07-08.
 */

class HomeItemViewHolder(
    parent: ViewGroup
) : BaseItemViewHolder<NoteEntity, HomeItemViewModel>(
    R.layout.layout_home_item_view, parent
) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) = viewHolderComponent.inject(this)
    override fun setupObservers() {
        super.setupObservers()

        viewModel.description.observe(this, Observer {
            Log.e("XD", it)
            //itemView.description.text = it
        })
    }
}
