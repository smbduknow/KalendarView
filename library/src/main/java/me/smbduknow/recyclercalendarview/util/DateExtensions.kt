package me.smbduknow.recyclercalendarview.util

import me.smbduknow.recyclercalendarview.model.Day
import me.smbduknow.recyclercalendarview.model.Month
import java.util.*


fun calendar(date: Date) = Calendar.getInstance().apply { time = date }


operator fun Date.inc() = calendar(this).apply {
    add(Calendar.DATE, 1)
}.time


fun Date.isToday(): Boolean {
    val cal = calendar(this)
    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH)
    val day = cal.get(Calendar.DAY_OF_MONTH)
    cal.time = Date()
    val nowYear = cal.get(Calendar.YEAR)
    val nowMonth = cal.get(Calendar.MONTH)
    val nowDay = cal.get(Calendar.DAY_OF_MONTH)
    return year == nowYear && month == nowMonth && day == nowDay
}

fun Date.isWeekend(vararg weekends: Int): Boolean {
    val cal = calendar(this)
    return weekends.contains(cal.get(Calendar.DAY_OF_WEEK))
}

fun Date.isInRange(from: Date, to: Date) = this in from..to

fun Date.getStartOfMonth() = calendar(this).apply {
    val firstDay = getActualMinimum(Calendar.DAY_OF_MONTH)
    set(Calendar.DAY_OF_MONTH, firstDay)
}.time

fun Date.getEndOfMonth() = calendar(this).apply {
    val lastDay = getActualMaximum(Calendar.DAY_OF_MONTH)
    set(Calendar.DAY_OF_MONTH, lastDay)
}.time

fun Date.getStartOfWeek(firstDayOfWeek: Int) = calendar(this).apply {
    set(Calendar.DAY_OF_WEEK, firstDayOfWeek)
}.time

fun Date.getEndOfWeek(firstDayOfWeek: Int) = calendar(this).apply {
    set(Calendar.DAY_OF_WEEK, firstDayOfWeek)
    add(Calendar.DATE, WEEK_DAYS_COUNT - 1)
}.time




fun buildMonth(date: Date): Month {
    val firstMonthDate = date.getStartOfMonth()
    val lastMonthDate = date.getEndOfMonth()
    val firstDisplayedDate = firstMonthDate.getStartOfWeek(Calendar.MONDAY)
    val lastDisplayedDate = lastMonthDate.getEndOfWeek(Calendar.MONDAY)

    val days = mutableListOf<Day>()

    var d = firstDisplayedDate
    while(d <= lastDisplayedDate) {
        days.add(Day(
                calendar = calendar(d),
                isBelongToMonth = d.isInRange(firstMonthDate, lastMonthDate),
                isWeekend = d.isWeekend(Calendar.SATURDAY, Calendar.SUNDAY),
                isCurrent = d.isToday(),
                isSelected = false,
                isDisabled = false
        ))
        d++
    }

    return Month(days, days.first()) // TODO first
}


