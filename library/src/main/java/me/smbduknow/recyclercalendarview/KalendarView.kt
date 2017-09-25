package me.smbduknow.recyclercalendarview

import android.content.Context
import android.support.annotation.AttrRes
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import me.smbduknow.recyclercalendarview.adapter.DaysAdapter
import me.smbduknow.recyclercalendarview.util.WEEK_DAYS_COUNT
import me.smbduknow.recyclercalendarview.util.buildMonth
import me.smbduknow.recyclercalendarview.view.MonthSliderView
import me.smbduknow.recyclercalendarview.view.WeekdaysView
import java.util.*

class KalendarView : LinearLayout {

    constructor(context: Context)
            : super(context) { init() }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init() }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init() }

    fun init(attrs: AttributeSet? = null) {

        orientation = VERTICAL

        val month = buildMonth(Date())

        val monthSliderView = MonthSliderView(context).apply {

        }
        val weekdaysView = WeekdaysView(context).apply {

        }
        val monthView = RecyclerView(context).apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context, WEEK_DAYS_COUNT).apply {
                isAutoMeasureEnabled = true
            }
            adapter = DaysAdapter().apply {
                items = month.days
            }
            adapter.notifyDataSetChanged()
        }

        Log.d("TAG", month.toString())

        addView(monthView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))

    }

}
