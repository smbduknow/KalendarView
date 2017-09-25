package me.smbduknow.recyclercalendarview.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.smbduknow.recyclercalendarview.adapter.viewholder.BaseDayHolder
import me.smbduknow.recyclercalendarview.adapter.viewholder.DayHolder
import me.smbduknow.recyclercalendarview.adapter.viewholder.OtherDayHolder
import me.smbduknow.recyclercalendarview.model.Day

class DaysAdapter : RecyclerView.Adapter<BaseDayHolder>() {

    companion object {
        const val TYPE_MONTH_DAY = 0
        const val TYPE_OTHER_MONTH_DAY = 1
    }

    var items: List<Day> = emptyList()

    override fun getItemViewType(position: Int): Int {
        val day = items[position]
        return if (day.isBelongToMonth)
            TYPE_MONTH_DAY
        else
            TYPE_OTHER_MONTH_DAY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        TYPE_MONTH_DAY -> DayHolder(textView(parent)) // TODO inflate view
        TYPE_OTHER_MONTH_DAY -> OtherDayHolder(textView(parent)) // TODO inflate view
        else -> throw IllegalArgumentException("Unknown view type")
    }

    override fun onBindViewHolder(holder: BaseDayHolder, position: Int) {
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
