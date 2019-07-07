package com.arindam.abode.ui.write

import androidx.lifecycle.viewModelScope
import com.arindam.abode.data.db.RoomDatabaseService
import com.arindam.abode.data.db.entity.NoteEntity
import com.arindam.abode.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

class WriteViewModel(roomDatabaseService: RoomDatabaseService) : BaseViewModel(roomDatabaseService) {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun saveNote(note: String) {
        viewModelScope.launch(Dispatchers.IO) {
            roomDatabaseService.noteDao().insert(NoteEntity(0, "Title", note))
        }
    }
}
