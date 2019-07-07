package com.arindam.abode.di

import javax.inject.Scope

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ViewModelScope