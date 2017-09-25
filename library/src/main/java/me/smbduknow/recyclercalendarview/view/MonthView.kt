package me.smbduknow.recyclercalendarview.view

import android.content.Context
import android.support.annotation.AttrRes
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

class MonthView : RecyclerView {

    constructor(context: Context)
            : super(context) { init() }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init() }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init() }

    private fun init() {

    }

}
