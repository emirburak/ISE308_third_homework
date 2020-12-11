package com.EmirBurakBekar_NoteToSelf.notetoself

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import android.widget.CheckBox
import android.widget.EditText


class DialogNewNote : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // All the rest of the code goes here
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_new_note, null)
        val editTitle = dialogView.findViewById(R.id.editTitle) as EditText
        val editDescription = dialogView.findViewById(R.id.editDescription) as EditText
        val checkBoxIdea = dialogView.findViewById(R.id.checkBoxIdea) as CheckBox
        val checkBoxTodo = dialogView.findViewById(R.id.checkBoxTodo) as CheckBox
        val checkBoxImportant = dialogView.findViewById(R.id.checkBoxImportant) as CheckBox
        val btnCancel = dialogView.findViewById(R.id.btnCancel) as Button
        val btnOK = dialogView.findViewById(R.id.btnOK) as Button

        builder.setView(dialogView).setMessage("Add a new note")

        // Handle the cancel button
        btnCancel.setOnClickListener {
            dismiss()
        }
        btnOK.setOnClickListener {
            // Creating new note
            val newNote = Note()
            // Setting its specifications to match the

            newNote.title = editTitle.text.toString()
            newNote.description = editDescription.text.toString()
            newNote.idea = checkBoxIdea.isChecked
            newNote.todo = checkBoxTodo.isChecked
            newNote.important = checkBoxImportant.isChecked

            // Getting reference to MainActivity
            val callingActivity = activity as MainActivity?

            // Passing newNote back to MainActivity
            callingActivity!!.createNewNote(newNote)

            // Quitting the dialog
            dismiss()
        }
        return builder.create()
    }
}
