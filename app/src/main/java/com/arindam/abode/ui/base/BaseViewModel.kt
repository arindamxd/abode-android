package com.arindam.abode.ui.base

import androidx.lifecycle.ViewModel
import com.arindam.abode.data.db.RoomDatabaseService

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

abstract class BaseViewModel(protected val roomDatabaseService: RoomDatabaseService) : ViewModel() {

    override fun onCleared() {
        super.onCleared()

        // Release Resources
        // roomDatabaseService.close()
        // viewModelScope.cancel()
    }
}