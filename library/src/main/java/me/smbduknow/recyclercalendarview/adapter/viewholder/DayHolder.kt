package me.smbduknow.recyclercalendarview.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import me.smbduknow.recyclercalendarview.model.Day
import me.smbduknow.recyclercalendarview.view.DayView

class DayHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val showOtherDates = false // TODO in settings

    // TextView dayView

    fun bind(day: Day) = with(itemView as DayView) {
        this.day = day
        this.showOtherDates = this@DayHolder.showOtherDates
    }
}
