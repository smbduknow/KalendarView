package me.smbduknow.recyclercalendarview.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.smbduknow.recyclercalendarview.adapter.viewholder.DayHolder
import me.smbduknow.recyclercalendarview.model.Day

class DaysAdapter : RecyclerView.Adapter<DayHolder>() {

    var items: List<Day> = emptyList()

    override fun getItemViewType(position: Int) = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = DayHolder(textView(parent))

    override fun onBindViewHolder(holder: DayHolder, position: Int) {
        val day = items[position]
        holder.bind(day)
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int): Long = items[position].calendar.timeInMillis

    private fun textView(parent: ViewGroup) = TextView(parent.context).apply {
        text = "xx"
        textAlignment = View.TEXT_ALIGNMENT_CENTER
        layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

}
