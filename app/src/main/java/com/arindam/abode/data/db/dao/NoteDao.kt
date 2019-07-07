package com.arindam.abode.data.db.dao

import androidx.room.*
import com.arindam.abode.data.db.entity.NoteEntity

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<NoteEntity>): List<Long>

    @Update
    fun update(entity: NoteEntity)

    @Delete
    fun delete(entity: NoteEntity)


    @Query("SELECT * from entity_note ORDER BY id DESC")
    fun getAllNotes(): List<NoteEntity>
}
