package com.arindam.abode.di.component

import com.arindam.abode.di.ActivityScope
import com.arindam.abode.di.module.ActivityModule
import com.arindam.abode.ui.home.HomeActivity
import dagger.Component

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: HomeActivity)
}
