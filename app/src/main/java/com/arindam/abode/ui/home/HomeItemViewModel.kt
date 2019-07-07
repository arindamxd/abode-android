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

    val description: LiveData<String> = Transformations.map(data) { it.description }
}