package me.smbduknow.recyclercalendarview.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import me.smbduknow.recyclercalendarview.adapter.DaysAdapter
import me.smbduknow.recyclercalendarview.model.Month

class MonthHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // View monthHeader
    // View monthGrid
    // View nextBtn
    // View prevBtn

    fun bind(month: Month) = with(itemView as RecyclerView) {
        val adapter = adapter as DaysAdapter
        adapter.items = month.days
        adapter.notifyDataSetChanged()
    }
}
