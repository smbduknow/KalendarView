package me.smbduknow.recyclercalendarview.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import me.smbduknow.recyclercalendarview.model.Day

abstract class BaseDayHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(day: Day)

}
