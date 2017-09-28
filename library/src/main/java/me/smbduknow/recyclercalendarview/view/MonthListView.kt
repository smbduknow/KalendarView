package me.smbduknow.recyclercalendarview.view

import android.content.Context
import android.support.annotation.AttrRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import me.smbduknow.recyclercalendarview.adapter.MonthAdapter
import me.smbduknow.recyclercalendarview.model.Month

class MonthListView : RecyclerView {

    constructor(context: Context)
            : super(context) { init(null) }

    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) { init(attrs) }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) { init(attrs) }

    private fun init(attrs: AttributeSet?) {

        isHorizontalScrollBarEnabled = false
        isVerticalFadingEdgeEnabled = false
        overScrollMode = View.OVER_SCROLL_NEVER

        layoutManager = LinearLayoutManager(context, orientation, false)

        adapter = MonthAdapter()

        PagerSnapHelper().attachToRecyclerView(this)

        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val curPos = (layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
                    if(curPos > -1) {
                        val month = (adapter as MonthAdapter).items[curPos]
                        onMonthChangeListener.invoke(month)
                    }
                }
            }
        })

    }

    var orientation = LinearLayout.HORIZONTAL
        set(value) {
            field = value
            (layoutManager as LinearLayoutManager).orientation = value
        }

    var months = emptyList<Month>()
        set(value) {
            field = value
            (adapter as MonthAdapter).items = value
        }

    var onMonthChangeListener = { month: Month -> Unit }

}
