package com.auliamnaufal.notesapp.utils

import android.content.Context
import android.view.View
import android.widget.AdapterView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.auliamnaufal.notesapp.R

object HelperFunctions {
    fun setPriorityIndicator(context: Context, cardView: CardView) : AdapterView.OnItemSelectedListener {
        val listener = object : AdapterView.OnItemSelectedListener {

            val arrayPriority = context.resources.getIntArray(R.array.priorities)

            val pink = ContextCompat.getColor(context, R.color.pink)
            val yellow = ContextCompat.getColor(context, R.color.yellow)
            val green = ContextCompat.getColor(context, R.color.green)

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> cardView.setCardBackgroundColor(pink)
                    1 -> cardView.setCardBackgroundColor(yellow)
                    2 -> cardView.setCardBackgroundColor(green)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        return listener
    }
}