package me.smbduknow.recyclercalendarview.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import me.smbduknow.recyclercalendarview.adapter.viewholder.MonthHolder
import me.smbduknow.recyclercalendarview.model.Month

class MonthAdapter() : RecyclerView.Adapter<MonthHolder>() {

    var items: List<Month> = emptyList()
        set(items) { notifyDataSetChanged() }

    override fun getItemViewType(position: Int) = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthHolder {
        return MonthHolder(parent) // TODO inflate view
    }

    override fun onBindViewHolder(holder: MonthHolder, position: Int) {
        val month = items[position]
        holder.bind(month)
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int)= items[position].firstDay.calendar.timeInMillis

}
