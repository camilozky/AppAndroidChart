package com.example.appandroidchart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set up line chart
        val lineChart = findViewById<LineChart>(R.id.line_chart)
        lineChart.setTouchEnabled(true)
        lineChart.isDragEnabled = true
        lineChart.setScaleEnabled(true)
        lineChart.setPinchZoom(true)
        lineChart.description.isEnabled = false

        // set up x-axis
        val xAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.axisMinimum = -720f
        xAxis.axisMaximum = 720f

        // set up y-axis
        val leftAxis = lineChart.axisLeft
        leftAxis.axisMinimum = -2f
        leftAxis.axisMaximum = 2f
        leftAxis.setDrawGridLines(false)
        lineChart.axisRight.isEnabled = false

        // create sine and cosine data sets
        val sinValues = mutableListOf<Entry>()
        val cosValues = mutableListOf<Entry>()
        for (i in -720..720 step 5) {
            val rad = Math.toRadians(i.toDouble())
            val sin = sin(rad).toFloat()
            val cos = cos(rad).toFloat()
            sinValues.add(Entry(i.toFloat(), sin))
            cosValues.add(Entry(i.toFloat(), cos))
        }

        // create sine data set
        val sinSet = LineDataSet(sinValues, "Sine")
        sinSet.color = Color.GREEN
        sinSet.fillColor = Color.GREEN
        sinSet.fillAlpha = 80
        sinSet.setDrawFilled(true)
        sinSet.setDrawCircles(false)
        sinSet.mode = LineDataSet.Mode.CUBIC_BEZIER

        // create cosine data set
        val cosSet = LineDataSet(cosValues, "Cosine")
        cosSet.color = Color.BLUE
        cosSet.fillColor = Color.BLUE
        cosSet.fillAlpha = 80
        cosSet.setDrawFilled(true)
        cosSet.setDrawCircles(false)
        cosSet.mode = LineDataSet.Mode.CUBIC_BEZIER

        // add data sets to line chart
        val data = LineData(sinSet, cosSet)
        lineChart.data = data

        // display chart
        lineChart.invalidate()
    }
}
