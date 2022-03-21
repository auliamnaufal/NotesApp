package com.auliamnaufal.notesapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.auliamnaufal.notesapp.R
import com.auliamnaufal.notesapp.data.local.entity.Notes
import com.auliamnaufal.notesapp.data.local.entity.Priority
import com.auliamnaufal.notesapp.databinding.RowItemNotesBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    var listNotes = ArrayList<Notes>()

    inner class MyViewHolder(val binding: RowItemNotesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        RowItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    )

    override fun onBindViewHolder(holder: HomeAdapter.MyViewHolder, position: Int) {
        val data = listNotes.get(position)
        holder.binding.apply {
            tvTitle.text = data.title
            tvDescription.text = data.body
            tvDate.text = data.dateCreated

            val colorIndicator = when(data.priority) {
                Priority.HIGH -> priorityIndicator.context.getColor(R.color.pink)
                Priority.MEDIUM -> priorityIndicator.context.getColor(R.color.yellow)
                Priority.LOW -> priorityIndicator.context.getColor(R.color.green)
            }

            priorityIndicator.setCardBackgroundColor(colorIndicator)
        }
    }

    override fun getItemCount(): Int = listNotes.size

    fun setData(notesData: List<Notes>?) {
        if (notesData == null) return
        val notesDiffUtil = DiffCallback(listNotes, notesData)
        val notesDiffutilResult = DiffUtil.calculateDiff(notesDiffUtil)
        listNotes.clear()
        listNotes.addAll(notesData)
        notesDiffutilResult.dispatchUpdatesTo(this)
    }
}