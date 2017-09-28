package me.smbduknow.recyclercalendarview.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import me.smbduknow.recyclercalendarview.adapter.viewholder.DayHolder
import me.smbduknow.recyclercalendarview.model.Day
import me.smbduknow.recyclercalendarview.view.DayView

class DaysAdapter : RecyclerView.Adapter<DayHolder>() {

    var items: List<Day> = emptyList()

    override fun getItemViewType(position: Int) = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = DayHolder(dayView(parent))

    override fun onBindViewHolder(holder: DayHolder, position: Int) {
        val day = items[position]
        holder.bind(day)
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int): Long = items[position].date.time

    private fun dayView(parent: ViewGroup) = DayView(parent.context).apply {
        layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

}
