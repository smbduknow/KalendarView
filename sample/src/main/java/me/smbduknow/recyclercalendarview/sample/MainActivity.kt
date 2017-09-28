package me.smbduknow.recyclercalendarview.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.smbduknow.recyclercalendarview.KalendarView
import java.util.*

class MainActivity : AppCompatActivity() {

    val kalendarView: KalendarView by lazy { kalendar_view }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val from = Date()
        val to = Date(from.time + 1000L * 3600 * 24 * 100) // 100 days
        kalendar_view.setDates(from, to)

    }
}
