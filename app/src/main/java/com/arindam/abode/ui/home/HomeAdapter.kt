package com.arindam.abode.ui.home

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.arindam.abode.data.db.entity.NoteEntity
import com.arindam.abode.ui.base.BaseAdapter

/**
 * Created by Arindam Karmakar on 2019-07-08.
 */

class HomeAdapter(
    parentLifecycle: Lifecycle,
    noteEntityList: ArrayList<NoteEntity>
) : BaseAdapter<NoteEntity, HomeItemViewHolder>(parentLifecycle, noteEntityList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeItemViewHolder(parent)
}
