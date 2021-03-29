package com.example.roommvvm.ui.Fragments.NotesList.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvm.R
import com.example.roommvvm.data.models.Note
import com.example.roommvvm.ui.Fragments.NotesList.NotesList
import com.example.roommvvm.ui.Fragments.NotesList.NotesListDirections
import kotlinx.android.synthetic.main.recycler_note_item.view.*

class NotesListAdapter: RecyclerView.Adapter<NotesListAdapter.MyViewHolder>() {

    var noteList = emptyList<Note>()
    val TAG = "NotesListAdapter"

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.cvNotes.setOnClickListener {
                val position = adapterPosition
                Log.d(TAG, "Title: ${noteList[position].note_title}")

                val action = NotesListDirections.actionNotesListToNotesUpdation(noteList[position])
                itemView.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_note_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentNote = noteList[position]

        holder.itemView.tvTitle.text = currentNote.note_title
        holder.itemView.tvDescription.text = currentNote.note_description
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun setData(note: List<Note>) {
        this.noteList = note
    }
}