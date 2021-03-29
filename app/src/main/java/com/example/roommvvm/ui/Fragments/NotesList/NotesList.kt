package com.example.roommvvm.ui.Fragments.NotesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.roommvvm.R
import com.example.roommvvm.databinding.FragmentNotesListBinding


class NotesList : Fragment(R.layout.fragment_notes_list) {
    private lateinit var binding: FragmentNotesListBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            binding = FragmentNotesListBinding.bind(view)



        fabOnClick()
    }

    private fun fabOnClick() {
        binding.fabAddNotes.setOnClickListener {
            findNavController().navigate(R.id.action_notesList_to_notesCreation)
        }
    }
}