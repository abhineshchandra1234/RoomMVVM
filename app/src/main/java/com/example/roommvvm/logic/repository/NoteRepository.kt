package com.example.roommvvm.logic.repository

import androidx.lifecycle.LiveData
import com.example.roommvvm.data.models.Note
import com.example.roommvvm.logic.dao.NoteDao

class NoteRepository(private val noteDao: NoteDao) {
    val getAllNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    suspend fun deleteAllNotes() {
        noteDao.deleteAll()
    }
}