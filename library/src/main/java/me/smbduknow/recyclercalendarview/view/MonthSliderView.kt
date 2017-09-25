package me.smbduknow.recyclercalendarview.view

import android.content.Context
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.widget.LinearLayout

class MonthSliderView : LinearLayout {

    constructor(context: Context)
            : super(context) { init() }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init() }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init() }



    private fun init(attrs: AttributeSet? = null) {
        orientation = HORIZONTAL
    }
}