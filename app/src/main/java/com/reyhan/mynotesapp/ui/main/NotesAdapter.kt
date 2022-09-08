package com.reyhan.mynotesapp.ui.main

import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.reyhan.mynotesapp.database.Notes
import com.reyhan.mynotesapp.databinding.ItemNoteBinding
import com.reyhan.mynotesapp.helper.NotesDiffCallback
import com.reyhan.mynotesapp.ui.insert.NotesAddUpdateActivity

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    inner class NotesViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(notes: Notes) {
            with(binding) {
                tvItemTitle.text = notes.title
                tvItemDate.text = notes.date
                tvItemDescription.text = notes.description
                cvItemNote.setOnClickListener {
                    val intent = Intent(it.context, NotesAddUpdateActivity::class.java)
                    intent.putExtra(NotesAddUpdateActivity.EXTRA_NOTE, notes)
                    it.context.startActivity(intent)
                }
            }
        }
    }

    private val listNotes = ArrayList<Notes>()
    fun setListNotes(listNotes: List<Notes>) {
        val diffCallback = NotesDiffCallback(this.listNotes, listNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listNotes.clear()
        this.listNotes.addAll(listNotes)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}