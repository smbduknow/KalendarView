package me.smbduknow.recyclercalendarview.adapter.viewholder

import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.smbduknow.recyclercalendarview.model.Day
import me.smbduknow.recyclercalendarview.util.format

class WeekdayHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(day: Day) = with(itemView as TextView) {
        val text = day.date.format("EE")
        val color = ResourcesCompat.getColor(resources, android.R.color.darker_gray, null)

        this.text = text
        this.setTextColor(color)
    }
}