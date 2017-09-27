package me.smbduknow.recyclercalendarview

import android.content.Context
import android.support.annotation.AttrRes
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import me.smbduknow.recyclercalendarview.adapter.MonthAdapter
import me.smbduknow.recyclercalendarview.adapter.WeekdaysAdapter
import me.smbduknow.recyclercalendarview.util.WEEK_DAYS_COUNT
import me.smbduknow.recyclercalendarview.util.buildMonth
import me.smbduknow.recyclercalendarview.view.MonthSliderView
import java.util.*

class KalendarView : LinearLayout {

    constructor(context: Context)
            : super(context) { init() }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init(attrs) }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init(attrs) }

    fun init(attrs: AttributeSet? = null) {

        orientation = VERTICAL

        val month = buildMonth(Date())
        val month2 = buildMonth(month.days.last().calendar.time)
        val month3 = buildMonth(month2.days.last().calendar.time)

        val monthSliderView = MonthSliderView(context).apply {

        }

        val monthTitleView = TextView(context).apply {
            text = month.firstDay.calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
        }

        val weekdaysView = RecyclerView(context).apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = GridLayoutManager(context, WEEK_DAYS_COUNT).apply {
                isAutoMeasureEnabled = true
            }
            adapter = WeekdaysAdapter().apply { items = month.days.subList(0, 7) }
        }

        val monthList = RecyclerView(context).apply {
            layoutManager = LinearLayoutManager(context, HORIZONTAL, false)
            adapter = MonthAdapter().apply { items = listOf(month, month2, month3) }
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                    if(newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val curPos = (layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
                        if(curPos > -1) {
                            val month = (adapter as MonthAdapter).items[curPos]
                            val title = month.firstDay.calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
                            monthTitleView.text = title
                        }
                    }
                }
            })
            PagerSnapHelper().attachToRecyclerView(this)
        }



        addView(monthTitleView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
        addView(weekdaysView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
        addView(monthList, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))

    }

}
