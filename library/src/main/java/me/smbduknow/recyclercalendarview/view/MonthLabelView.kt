package me.smbduknow.recyclercalendarview.view

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView
import me.smbduknow.recyclercalendarview.R
import me.smbduknow.recyclercalendarview.model.Month
import me.smbduknow.recyclercalendarview.util.format

class MonthLabelView : TextView {

    constructor(context: Context)
            : super(context) { init(null) }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init(attrs) }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init(attrs) }

    private fun init(attrs: AttributeSet?) {
        gravity = Gravity.CENTER
        val padding = resources.getDimensionPixelSize(R.dimen.space_large)
        setPadding(padding, padding, padding, padding)
    }

    var month: Month? = null
        set(value) {
            field = value
            if(value == null) return
            text = value.firstDay.date.format("LLLL yyyy")
        }

}