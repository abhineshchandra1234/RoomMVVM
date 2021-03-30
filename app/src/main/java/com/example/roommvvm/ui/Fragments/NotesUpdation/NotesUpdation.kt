package com.example.roommvvm.ui.Fragments

import android.os.Binder
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roommvvm.R
import com.example.roommvvm.data.models.Note
import com.example.roommvvm.databinding.FragmentNotesUpdationBinding
import com.example.roommvvm.ui.viewModels.NoteViewModel


class NotesUpdation : Fragment(R.layout.fragment_notes_updation) {
    val TAG = "Main"

    private var title = ""
    private var description = ""

    private lateinit var binding: FragmentNotesUpdationBinding
    private lateinit var noteViewModel: NoteViewModel
    private val args by navArgs<NotesUpdationArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentNotesUpdationBinding.bind(view)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        binding.etNotesHeadingUpdate.setText(args.selectedNote.note_title)
        binding.etNotesDescriptionUpdate.setText(args.selectedNote.note_description)

        binding.btnUpdateNotes.setOnClickListener {
            updateNote()
        }

        setHasOptionsMenu(true)
    }

    private fun updateNote() {
        title = binding.etNotesHeadingUpdate.text.toString()
        description = binding.etNotesDescriptionUpdate.text.toString()

        if (!(title.isEmpty() || description.isEmpty())) {
            val note = Note(args.selectedNote.id, title, description)

            noteViewModel.updateNote(note)
            Toast.makeText(context, "Note updated successfully", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_notesUpdation_to_notesList)
        } else {
            Toast.makeText(context, "Please fill all the fields!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.iconDelete -> deleteNote(args.selectedNote)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteNote(selectedNote: Note) {
        noteViewModel.deleteNote(selectedNote)
        Toast.makeText(context, "Note successfully deleted!", Toast.LENGTH_SHORT).show()

        findNavController().navigate(R.id.action_notesUpdation_to_notesList)
    }
}