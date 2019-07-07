package com.arindam.abode.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arindam.abode.utils.getCurrentTimeStamp
import org.jetbrains.annotations.NotNull

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

@Entity(tableName = "entity_note")
data class NoteEntity(

    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @NotNull
    @ColumnInfo(name = "timestamp")
    var timestamp: String = getCurrentTimeStamp()
)
