package me.smbduknow.recyclercalendarview.view

import android.content.Context
import android.support.annotation.AttrRes
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import me.smbduknow.recyclercalendarview.adapter.WeekdaysAdapter
import me.smbduknow.recyclercalendarview.model.Month
import me.smbduknow.recyclercalendarview.util.WEEK_DAYS_COUNT

class WeekdaysView : RecyclerView {

    constructor(context: Context)
            : super(context) { init(null) }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init(attrs) }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init(attrs) }

    private fun init(attrs: AttributeSet?) {
        setHasFixedSize(true)
        isNestedScrollingEnabled = false
        layoutManager = GridLayoutManager(context, WEEK_DAYS_COUNT).apply {
            isAutoMeasureEnabled = true
        }
        adapter = WeekdaysAdapter()
    }

    var month: Month? = null
        set(value) {
            field = value
            if(value == null) return
            (adapter as WeekdaysAdapter).items = value.days.subList(0, 7) ?: emptyList()
        }



}