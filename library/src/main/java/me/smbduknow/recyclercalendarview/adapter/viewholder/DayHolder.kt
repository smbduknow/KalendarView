package me.smbduknow.recyclercalendarview.adapter.viewholder

import android.view.View
import android.widget.TextView
import me.smbduknow.recyclercalendarview.model.Day

class DayHolder(itemView: View) : BaseDayHolder(itemView) {

    // TextView dayView

    override fun bind(day: Day) {
        val text = day.dayNumber.toString()

        itemView as TextView
        itemView.text = text
    }
}
