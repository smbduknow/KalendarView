package me.smbduknow.recyclercalendarview.adapter.viewholder

import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.smbduknow.recyclercalendarview.model.Day
import java.util.*

class WeekdayHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // TextView dayView

    fun bind(day: Day) = with(itemView as TextView) {
        val text = day.calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault())
        val color = ResourcesCompat.getColor(resources, android.R.color.darker_gray, null)

        this.text = text
        this.setTextColor(color)
    }
}