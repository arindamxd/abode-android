package com.arindam.abode.data.db

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arindam.abode.data.db.dao.NoteDao

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

abstract class RoomDatabaseService : RoomDatabase() {

    companion object {

        @VisibleForTesting
        private val DATABASE_NAME = "abode-db"

        fun buildDatabase(appContext: Context): RoomDatabaseService {
            return Room.databaseBuilder(appContext, RoomDatabaseService::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun noteDao(): NoteDao
}
