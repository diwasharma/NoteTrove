package com.example.thenotesapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notesroompractice.R
import com.example.thenotesapp.database.noteDatabase
import com.example.thenotesapp.repository.noteRepository
import com.example.thenotesapp.viewmodel.noteViewModelFactory
import com.example.thenotesapp.viewmodel.noteViewmodel

class MainActivity : AppCompatActivity(){
    lateinit var noteViewmodel: noteViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewmodel()
    }
    private fun setupViewmodel(){
        val noteRepository= noteRepository(noteDatabase(this))
        val viewModelProviderFactory= noteViewModelFactory(application,noteRepository)
        noteViewmodel=ViewModelProvider(this,viewModelProviderFactory)[noteViewmodel::class.java]
    }
}

