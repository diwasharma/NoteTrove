package com.example.thenotesapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notesroompractice.R
import com.example.notesroompractice.databinding.FragmentHomefragmentBinding
import com.example.thenotesapp.MainActivity
import com.example.thenotesapp.adapter.noteAdapter
import com.example.thenotesapp.model.NOTE
import com.example.thenotesapp.viewmodel.noteViewmodel

class homefragment : Fragment(R.layout.fragment_homefragment),SearchView.OnQueryTextListener, MenuProvider {
    private var homeBinding: FragmentHomefragmentBinding? = null
    private val binding get() = homeBinding!!

    private lateinit var notesViewmodel: noteViewmodel
    private lateinit var noteAdapter: noteAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding= FragmentHomefragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost:MenuHost=requireActivity()
        menuHost.addMenuProvider(this,viewLifecycleOwner,Lifecycle.State.RESUMED)

        notesViewmodel=(activity as MainActivity).noteViewmodel
        setupHomeRecyclerView()
        binding.addNoteFab.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }
    private fun updateUI(note:List<NOTE>?){
        if(note!=null){
            if(note.isNotEmpty()){
                binding.emptyNotesImage.visibility=View.GONE
                binding.homeRecyclerView.visibility=View.VISIBLE
            }
            else{
                binding.emptyNotesImage.visibility=View.VISIBLE
                binding.homeRecyclerView.visibility=View.GONE
            }
        }
    }
    private fun setupHomeRecyclerView(){
        noteAdapter= noteAdapter()
        binding.homeRecyclerView.apply {
            layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter=noteAdapter
        }
        activity?.let {
            notesViewmodel.getAllNotes().observe(viewLifecycleOwner){note->

                noteAdapter.differ.submitList(note)
                updateUI(note)
            }
        }
    }
    private fun searchNote(query:String?){
        val searchQuery="%$query"
        notesViewmodel.searchNote(searchQuery).observe(this){list->
            noteAdapter.differ.submitList(list)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if(newText !=null){
            searchNote(newText)
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        homeBinding=null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.home_menu,menu)
        val menuSearch =menu.findItem(R.id.searchMenu).actionView as SearchView
        menuSearch.isSubmitButtonEnabled=false
        menuSearch.setOnQueryTextListener(this)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return false
    }

}