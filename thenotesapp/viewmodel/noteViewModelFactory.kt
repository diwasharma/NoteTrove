package com.example.thenotesapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thenotesapp.repository.noteRepository

class noteViewModelFactory(val app:Application , private val noteRepository: noteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return noteViewmodel(app, noteRepository) as T
    }
}