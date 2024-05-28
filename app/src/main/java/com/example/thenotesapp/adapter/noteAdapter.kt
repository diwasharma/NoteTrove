package com.example.thenotesapp.adapter


import android.annotation.SuppressLint
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notesroompractice.databinding.NoteLayoutBinding
import com.example.thenotesapp.fragment.homefragmentDirections
import com.example.thenotesapp.model.NOTE

class noteAdapter : RecyclerView.Adapter<noteAdapter.noteViewHolder>() {
    class noteViewHolder(val itemBinding: NoteLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback= object : DiffUtil.ItemCallback<NOTE>(){
        override fun areItemsTheSame(oldItem:NOTE, newItem: NOTE): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.noteDesc == newItem.noteDesc &&
                    oldItem.noteTitle == newItem.noteTitle
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: NOTE, newItem: NOTE): Boolean {
            return oldItem == newItem
        }

    }
    val differ= AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteViewHolder {
        return noteViewHolder(
            NoteLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: noteViewHolder, position: Int) {
        val currentNote= differ.currentList[position]
        holder.itemBinding.noteTitle.text=currentNote.noteTitle
        holder.itemBinding.noteDesc.text=currentNote.noteDesc

        holder.itemView.setOnClickListener {
            val direction=homefragmentDirections.actionHomeFragmentToEditNoteFragment(currentNote)
            it.findNavController().navigate(direction)
        }
    }
}

