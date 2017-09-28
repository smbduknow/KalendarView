package me.smbduknow.recyclercalendarview

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.widget.LinearLayout
import me.smbduknow.recyclercalendarview.model.Month
import me.smbduknow.recyclercalendarview.util.buildMonth
import me.smbduknow.recyclercalendarview.util.calendar
import me.smbduknow.recyclercalendarview.util.isSameMonth
import me.smbduknow.recyclercalendarview.view.MonthLabelView
import me.smbduknow.recyclercalendarview.view.MonthListView
import me.smbduknow.recyclercalendarview.view.WeekdaysView
import java.util.*

class KalendarView : LinearLayout {

    private lateinit var monthTitleView: MonthLabelView
    private lateinit var weekdaysView: WeekdaysView
    private lateinit var monthList: MonthListView

    constructor(context: Context)
            : super(context) { init() }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init(attrs) }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init(attrs) }

    fun init(attrs: AttributeSet? = null) {

        orientation = VERTICAL

        monthTitleView = MonthLabelView(context)

        weekdaysView = WeekdaysView(context)

        monthList = MonthListView(context).apply {
            orientation = HORIZONTAL
            onMonthChangeListener = { monthTitleView.month = it }
        }


        addView(monthTitleView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
        addView(weekdaysView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
        addView(monthList, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))
    }

    fun setDates(from: Date, to: Date) {
        val fromCal = calendar(from)
        val toCal = calendar(to)

        val months = mutableListOf<Month>()

        while(!fromCal.isSameMonth(toCal)) {
            months.add(buildMonth(fromCal.time))
            fromCal.add(Calendar.MONTH, 1)
        }

        monthTitleView.month = months.first()
        weekdaysView.month = months.first()
        monthList.months = months

    }

}


