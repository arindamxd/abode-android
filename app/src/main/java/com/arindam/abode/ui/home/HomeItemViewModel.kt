package com.arindam.abode.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.arindam.abode.data.db.RoomDatabaseService
import com.arindam.abode.data.db.entity.NoteEntity
import com.arindam.abode.ui.base.BaseItemViewModel
import javax.inject.Inject

/**
 * Created by Arindam Karmakar on 2019-07-08.
 */

class HomeItemViewModel @Inject constructor(
    roomDatabaseService: RoomDatabaseService
) : BaseItemViewModel<NoteEntity>(roomDatabaseService) {

    val noteId: LiveData<Int> = Transformations.map(data) { it.id }
    val title: LiveData<String> = Transformations.map(data) { it.title }
    val description: LiveData<String> = Transformations.map(data) { it.description }
    val date: LiveData<String> = Transformations.map(data) { it.timestamp }

    fun onItemClick(position: Int) {

    }
}