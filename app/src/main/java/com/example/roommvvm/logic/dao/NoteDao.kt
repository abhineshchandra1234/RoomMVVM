package com.example.roommvvm.logic.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roommvvm.data.models.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("select * from note_table order by id desc")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("delete from note_table")
    suspend fun deleteAll()
}