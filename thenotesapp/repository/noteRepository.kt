package com.example.thenotesapp.repository

import com.example.thenotesapp.database.noteDatabase
import com.example.thenotesapp.model.NOTE

class noteRepository(private val db: noteDatabase) {
    suspend fun insertNote(note: NOTE)= db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note: NOTE)= db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: NOTE)= db.getNoteDao().updateNote(note)

    fun getAllNotes()=db.getNoteDao().getAllNotes()
    fun searchNote(query: String?)=db.getNoteDao().searchNote(query )
}