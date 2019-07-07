package com.arindam.abode.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.arindam.abode.data.db.RoomDatabaseService
import com.arindam.abode.ui.base.BaseActivity
import com.arindam.abode.ui.home.HomeViewModel
import com.arindam.abode.ui.write.WriteViewModel
import com.arindam.abode.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideHomeViewModel(roomDatabaseService: RoomDatabaseService): HomeViewModel = ViewModelProviders.of(
        activity,
        ViewModelProviderFactory(HomeViewModel::class) {
            HomeViewModel(roomDatabaseService)
        }).get(HomeViewModel::class.java)

    @Provides
    fun provideWriteViewModel(roomDatabaseService: RoomDatabaseService): WriteViewModel = ViewModelProviders.of(
        activity,
        ViewModelProviderFactory(WriteViewModel::class) {
            WriteViewModel(roomDatabaseService)
        }).get(WriteViewModel::class.java)

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)
}
