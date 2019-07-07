package com.arindam.abode.di.module

import android.app.Application
import android.content.Context
import com.arindam.abode.TaskApplication
import com.arindam.abode.data.db.RoomDatabaseService
import com.arindam.abode.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

@Module
class ApplicationModule(private val application: TaskApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideRoomDatabaseService(): RoomDatabaseService = RoomDatabaseService()
}
