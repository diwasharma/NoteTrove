package com.example.thenotesapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notesroompractice.R
import com.example.notesroompractice.databinding.FragmentEditnotefragmentBinding
import com.example.thenotesapp.MainActivity
import com.example.thenotesapp.model.NOTE
import com.example.thenotesapp.viewmodel.noteViewmodel
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class editnotefragment : Fragment(R.layout.fragment_editnotefragment),MenuProvider {

    private var editNoteBinding:FragmentEditnotefragmentBinding? = null
    private val binding get() = editNoteBinding!!

    private lateinit var notesViewmodel: noteViewmodel
    private lateinit var currentNote: NOTE

    private val args: editnotefragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        editNoteBinding=FragmentEditnotefragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost =requireActivity()
        menuHost.addMenuProvider(this,viewLifecycleOwner, Lifecycle.State.RESUMED)

        notesViewmodel=(activity as MainActivity).noteViewmodel
        currentNote= args.note!!

        binding.editNoteTitle.setText(currentNote.noteTitle)
        binding.editNoteDesc.setText(currentNote.noteDesc)

        binding.editNoteFab.setOnClickListener {
            val noteTitle=binding.editNoteTitle.text.toString().trim()
            val noteDesc=binding.editNoteDesc.text.toString().trim()

            if(noteTitle.isNotEmpty()){
                val note= NOTE(currentNote.id,noteTitle,noteDesc)
                notesViewmodel.updatenote(note)
                view.findNavController().popBackStack(R.id.homeFragment,false)
            }else{
                Toast.makeText(context,"Please Enter Note",Toast.LENGTH_SHORT).show()

            }
        }
    }
    private fun deletenote(){
        AlertDialog.Builder(requireActivity()).apply {
            setTitle("Delete Note")
            setMessage("Do you want to delete this Note?")
            setPositiveButton("Delete"){_,_ ->
                notesViewmodel.deletenote(currentNote)
                Toast.makeText(context,"Note Deleted",Toast.LENGTH_SHORT).show()
                view?.findNavController()?.popBackStack(R.id.homeFragment,false)
            }
            setNeutralButton("Cancel",null)
        }.create().show()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.menu_edit_note,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            R.id.deleteMenu -> {
                deletenote()
                true
            }else -> false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        editNoteBinding = null
    }
}



