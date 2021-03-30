package com.example.roommvvm.ui.Fragments.NotesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roommvvm.R
import com.example.roommvvm.data.models.Note
import com.example.roommvvm.databinding.FragmentNotesListBinding
import com.example.roommvvm.ui.Fragments.NotesList.adapters.NotesListAdapter
import com.example.roommvvm.ui.viewModels.NoteViewModel
import kotlinx.android.synthetic.main.fragment_notes_list.*


class NotesList : Fragment(R.layout.fragment_notes_list) {
    private lateinit var binding: FragmentNotesListBinding
    private lateinit var noteList: List<Note>
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var adapter: NotesListAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            binding = FragmentNotesListBinding.bind(view)

        //Adapter
        adapter = NotesListAdapter()
        binding.rvNotes.adapter = adapter
        binding.rvNotes.layoutManager = LinearLayoutManager(context)

        //ViewModel
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        noteViewModel.getAllNotes.observe(viewLifecycleOwner, {

            adapter.setData(it)
            noteList = it

            if (it.isEmpty()) {
                binding.rvNotes.visibility = View.GONE
                binding.tvEmptyNote.visibility = View.VISIBLE
            } else {
                binding.rvNotes.visibility = View.VISIBLE
                binding.tvEmptyNote.visibility = View.GONE
            }
        })



        fabOnClick()
    }

    private fun fabOnClick() {
        binding.fabAddNotes.setOnClickListener {
            findNavController().navigate(R.id.action_notesList_to_notesCreation)
        }
    }
}