package com.arindam.abode.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.arindam.abode.data.db.RoomDatabaseService
import com.arindam.abode.data.db.entity.NoteEntity
import com.arindam.abode.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

class HomeViewModel(roomDatabaseService: RoomDatabaseService) : BaseViewModel(roomDatabaseService) {

    private val noteListLiveData: MutableLiveData<List<NoteEntity>> = MutableLiveData()
    fun getNotesData(): LiveData<List<NoteEntity>> = Transformations.map(noteListLiveData) { it }

    fun fetchDataList() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(300)
            noteListLiveData.postValue(roomDatabaseService.noteDao().getAllNotes())
        }
    }
}