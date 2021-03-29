package com.example.roommvvm.ui.Fragments.NotesList.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvm.data.models.Note

class NotesListAdapter: RecyclerView.Adapter<NotesListAdapter.MyViewHolder>() {

    var noteList = emptyList<Note>()
    val TAG = "NotesListAdapter"

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            TODO()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentNote = noteList[position]

        TODO()
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}