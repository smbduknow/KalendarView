package me.smbduknow.recyclercalendarview.view

import android.content.Context
import android.support.annotation.AttrRes
import android.support.v4.content.res.ResourcesCompat
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView
import me.smbduknow.recyclercalendarview.model.Day

class DayView : TextView {

    var colorTextDay = ResourcesCompat.getColor(resources, android.R.color.black, null)
    var colorTextOtherDay = ResourcesCompat.getColor(resources, android.R.color.darker_gray, null)
    var colorTextWeekend = ResourcesCompat.getColor(resources, android.R.color.holo_blue_dark, null)
    var colorTextAccent = ResourcesCompat.getColor(resources, android.R.color.white, null)
    var colorAccent = ResourcesCompat.getColor(resources, android.R.color.holo_blue_light, null)

    private val colorTransparent = ResourcesCompat.getColor(resources, android.R.color.transparent, null)

    var showOtherDates = false
        set(value) {
            field = value
            reinit()
        }

    var day: Day? = null
        set(value) {
            field = value
            reinit()
        }

    constructor(context: Context)
            : super(context) { init(null) }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init(attrs) }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init(attrs) }

    private fun init(attrs: AttributeSet?) {
        gravity = Gravity.CENTER
    }


    private fun reinit() {
        day?.let { day ->
            val text = if (day.isBelongToMonth || showOtherDates) day.dayNumber.toString() else null
            val textColor = when {
                !day.isBelongToMonth -> colorTextOtherDay
                day.isCurrent -> colorTextAccent
                day.isWeekend -> colorTextWeekend
                else -> colorTextDay
            }
            val bgColor = if (day.isCurrent && day.isBelongToMonth) colorAccent else colorTransparent

            this.text = text
            this.setTextColor(textColor)
            this.setBackgroundColor(bgColor)
        }
    }
}