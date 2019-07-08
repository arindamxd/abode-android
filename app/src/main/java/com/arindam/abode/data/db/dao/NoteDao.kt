package com.arindam.abode.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arindam.abode.data.db.entity.NoteEntity

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: NoteEntity)

    @Query("SELECT * FROM entity_note ORDER BY id ASC")
    fun getAllNotes(): List<NoteEntity>

    @Query("SELECT description FROM entity_note WHERE id =:noteId")
    fun getNoteTextById(noteId: Int): String

    @Query("UPDATE entity_note SET description =:noteText WHERE id =:noteId")
    fun updateNoteById(noteId: Int, noteText: String)
}
