package com.arindam.abode

import android.app.Application
import com.arindam.abode.di.component.ApplicationComponent
import com.arindam.abode.di.component.DaggerApplicationComponent
import com.arindam.abode.di.module.ApplicationModule

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

class TaskApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(this)
    }
}
