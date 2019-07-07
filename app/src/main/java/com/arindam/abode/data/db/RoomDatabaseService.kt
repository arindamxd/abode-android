package com.arindam.abode.data.db

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arindam.abode.data.db.dao.NoteDao
import com.arindam.abode.data.db.entity.NoteEntity

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

@Database(entities = [NoteEntity::class], exportSchema = false, version = 1)
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
