package me.smbduknow.recyclercalendarview.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import me.smbduknow.recyclercalendarview.adapter.viewholder.MonthHolder
import me.smbduknow.recyclercalendarview.model.Month
import me.smbduknow.recyclercalendarview.util.WEEK_DAYS_COUNT

class MonthAdapter : RecyclerView.Adapter<MonthHolder>() {

    var items: List<Month> = emptyList()

    override fun getItemViewType(position: Int) = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthHolder {
        return MonthHolder(monthView(parent))
    }

    override fun onBindViewHolder(holder: MonthHolder, position: Int) {
        val month = items[position]
        holder.bind(month)
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int)= items[position].firstDay.calendar.timeInMillis



    private fun monthView(parent: ViewGroup) = RecyclerView(parent.context).apply {
        setHasFixedSize(true)
        isNestedScrollingEnabled = false
        layoutManager = GridLayoutManager(context, WEEK_DAYS_COUNT).apply {
            isAutoMeasureEnabled = true
        }
        adapter = DaysAdapter()
        setPadding(10, 10, 10, 10)

        layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}
