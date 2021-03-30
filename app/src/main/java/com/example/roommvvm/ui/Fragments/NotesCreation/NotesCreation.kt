package com.example.roommvvm.ui.Fragments.NotesCreation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roommvvm.R
import com.example.roommvvm.data.models.Note
import com.example.roommvvm.databinding.FragmentNotesCreationBinding
import com.example.roommvvm.ui.viewModels.NoteViewModel
import kotlinx.android.synthetic.main.fragment_notes_creation.*


class NotesCreation : Fragment(R.layout.fragment_notes_creation) {

    val TAG = "Main"

    private var title = ""
    private var description = ""

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var binding: FragmentNotesCreationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentNotesCreationBinding.bind(view)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        binding.btnAddNotes.setOnClickListener {
            addNoteToDB()
        }
    }

    private fun addNoteToDB() {
        title = binding.etNotesHeading.text.toString()
        description = binding.etNotesDescription.text.toString()

        if (!(title.isEmpty()||description.isEmpty())) {
            val note = Note(0,title,description)

            noteViewModel.addNote(note)
            Toast.makeText(context, "Note created successfully", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_notesCreation_to_notesList)
        } else {
            Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }
    }
}