package com.arindam.abode.ui.base

import androidx.lifecycle.MutableLiveData
import com.arindam.abode.data.db.RoomDatabaseService

/**
 * Created by Arindam Karmakar on 2019-07-08.
 */

abstract class BaseItemViewModel<T : Any>(
    roomDatabaseService: RoomDatabaseService
) : BaseViewModel(roomDatabaseService) {

    val data: MutableLiveData<T> = MutableLiveData()

    fun onManualCleared() = onCleared()
    fun updateData(data: T) {
        this.data.postValue(data)
    }
}