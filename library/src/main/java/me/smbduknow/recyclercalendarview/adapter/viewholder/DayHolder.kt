package me.smbduknow.recyclercalendarview.adapter.viewholder

import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.smbduknow.recyclercalendarview.model.Day

class DayHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // TextView dayView

    fun bind(day: Day) = with(itemView as TextView) {
        val text = day.dayNumber.toString()
        val color = if(day.isBelongToMonth)
            ResourcesCompat.getColor(resources, android.R.color.black, null)
        else
            ResourcesCompat.getColor(resources, android.R.color.darker_gray, null)

        this.text = text
        this.setTextColor(color)
    }
}
