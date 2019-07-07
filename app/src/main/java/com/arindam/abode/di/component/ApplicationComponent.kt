package com.arindam.abode.di.component

import android.app.Application
import android.content.Context
import com.arindam.abode.TaskApplication
import com.arindam.abode.data.db.RoomDatabaseService
import com.arindam.abode.di.ApplicationContext
import com.arindam.abode.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: TaskApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getRoomDatabaseService(): RoomDatabaseService
}
