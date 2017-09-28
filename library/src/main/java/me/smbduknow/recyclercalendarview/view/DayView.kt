package me.smbduknow.recyclercalendarview.view

import android.content.Context
import android.support.annotation.AttrRes
import android.support.v4.content.res.ResourcesCompat
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView
import me.smbduknow.recyclercalendarview.R
import me.smbduknow.recyclercalendarview.model.Day

class DayView : TextView {

    constructor(context: Context)
            : super(context) { init(null) }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init(attrs) }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init(attrs) }

    private fun init(attrs: AttributeSet?) {
        gravity = Gravity.CENTER
        val padding = resources.getDimensionPixelSize(R.dimen.space_large)
//        setPadding(padding, padding, padding, padding)
    }

    var showOtherDates = false

    var day: Day? = null
        set(value) {
            field = value
            if(value == null) return
            val text = if(value.isBelongToMonth || showOtherDates) value.dayNumber.toString() else null
            val color = if(value.isBelongToMonth)
                ResourcesCompat.getColor(resources, android.R.color.black, null)
            else
                ResourcesCompat.getColor(resources, android.R.color.darker_gray, null)

            this.text = text
            this.setTextColor(color)
            if(value.isCurrent && value.isBelongToMonth) this.setBackgroundResource(android.R.color.holo_blue_light)
        }

}