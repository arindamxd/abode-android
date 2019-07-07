package com.arindam.abode.ui.home

import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.arindam.abode.R
import com.arindam.abode.data.db.entity.NoteEntity
import com.arindam.abode.di.component.ViewHolderComponent
import com.arindam.abode.ui.base.BaseItemViewHolder
import com.arindam.abode.ui.write.WriteActivity
import kotlinx.android.synthetic.main.layout_home_item_view.view.*

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

        viewModel.title.observe(this, Observer {
            itemView.itemTitle.text = it
        })
        viewModel.description.observe(this, Observer {
            itemView.itemNote.text = it
        })
        viewModel.date.observe(this, Observer {
            itemView.itemDate.text = it
        })
    }

    override fun setupView(view: View) {
        view.setOnClickListener {
            Log.e("XD", viewModel.title.value)
            view.context.startActivity(Intent(view.context, WriteActivity::class.java))
            viewModel.onItemClick(adapterPosition)
        }
    }
}
