package com.arindam.abode.data.db.dao

import androidx.room.*

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: NoteDao)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<NoteDao>): List<Long>

    @Update
    fun update(entity: NoteDao)

    @Delete
    fun delete(entity: NoteDao)
}
