package me.smbduknow.recyclercalendarview.view

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import java.text.DateFormatSymbols
import java.util.*

class WeekdaysView : LinearLayout {

    private var firstDayOfWeek: Int = Calendar.MONDAY

    constructor(context: Context)
            : super(context) { init() }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init() }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init() }

    private fun init(attrs: AttributeSet? = null) {
        orientation = HORIZONTAL

        val weekdays = DateFormatSymbols.getInstance(Locale("ru")).shortWeekdays
        for(dayName in weekdays) {
            addView(
                    TextView(context).apply { text = dayName.toLowerCase() },
                    LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            )
        }
    }

}