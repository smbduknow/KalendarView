package me.smbduknow.recyclercalendarview.adapter

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import me.smbduknow.recyclercalendarview.adapter.viewholder.WeekdayHolder
import me.smbduknow.recyclercalendarview.model.Day

class WeekdaysAdapter : RecyclerView.Adapter<WeekdayHolder>() {

    var items: List<Day> = emptyList()

    override fun getItemViewType(position: Int) = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = WeekdayHolder(textView(parent))

    override fun onBindViewHolder(holder: WeekdayHolder, position: Int) {
        val day = items[position]
        holder.bind(day)
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int): Long = items[position].date.time

    private fun textView(parent: ViewGroup) = TextView(parent.context).apply {
        gravity = Gravity.CENTER
        layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )

    }

}