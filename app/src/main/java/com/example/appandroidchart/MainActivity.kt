package com.example.appandroidchart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chart = findViewById<LineChart>(R.id.chart)
        val sinEntries = ArrayList<Entry>()
        val cosEntries = ArrayList<Entry>()

        for (i in 0..360 step 10) {
            val radians = i * (Math.PI / 180)
            val sin = sin(radians).toFloat()
            val cos = cos(radians).toFloat()
            sinEntries.add(Entry(i.toFloat(), sin))
            cosEntries.add(Entry(i.toFloat(), cos))
        }
        val sinDataSet = LineDataSet(sinEntries, "Sine")
        sinDataSet.color = Color.RED
        val cosDataSet = LineDataSet(cosEntries, "Cosine")
        cosDataSet.color = Color.BLUE
        val data = LineData(sinDataSet, cosDataSet)
        chart.data = data
        chart.invalidate()
    }
}
