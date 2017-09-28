package me.smbduknow.recyclercalendarview.model

import me.smbduknow.recyclercalendarview.util.calendar
import java.util.*


data class Day(
        val date: Date,
        val isBelongToMonth: Boolean = false,
        val isWeekend: Boolean = false,
        val isCurrent: Boolean = false,
        val isSelected: Boolean = false,
        val isDisabled: Boolean = false
) {

    val dayNumber: Int
        get() = calendar(date).get(Calendar.DAY_OF_MONTH)

}


data class Month(
        val days: List<Day>,
        val firstDay: Day
) {

    val monthNumber: Int
        get() = calendar(firstDay.date).get(Calendar.MONTH)

    /**
     * Returns days that belong to current month
     */
    val daysOfMonth: List<Day>
        get() = days.filter { it.isBelongToMonth }

}