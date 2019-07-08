package com.arindam.abode.ui.write

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arindam.abode.data.db.RoomDatabaseService
import com.arindam.abode.data.db.entity.NoteEntity
import com.arindam.abode.ui.base.BaseViewModel
import com.arindam.abode.utils.common.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

class WriteViewModel(roomDatabaseService: RoomDatabaseService) : BaseViewModel(roomDatabaseService) {

    private var isEdit: Boolean = false
    private var editNoteId: Int? = null
    private var editNoteText: MutableLiveData<String> = MutableLiveData()

    fun isEdit(): Boolean = isEdit
    fun getEditNoteText(): LiveData<String> = editNoteText

    fun setNoteInfo(extras: Bundle?) {
        isEdit = extras?.getBoolean(Constant.IS_EDIT_PAGE) ?: false
        editNoteId = extras?.getInt(Constant.EDIT_NOTE_ID)

        editNoteId?.let {
            viewModelScope.launch(Dispatchers.IO) {
                editNoteText.postValue(roomDatabaseService.noteDao().getNoteTextById(it))
            }
        }
    }

    fun saveNote(note: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (isEdit) {
                editNoteId?.let { roomDatabaseService.noteDao().updateNoteById(it, note) }
            } else {
                roomDatabaseService.noteDao().insert(NoteEntity(0, "Title", note))
            }
        }
    }
}
