package com.bitcodetech.customviews4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var graphView : GraphView
    private lateinit var btnRefresh : Button

    private lateinit var values : ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initViews()

        /*graphView = GraphView(this)
        graphView.values = values
        setContentView(graphView)*/
    }

    private fun initViews() {
        btnRefresh = findViewById(R.id.btnRefresh)
        graphView = findViewById(R.id.graphView)

        btnRefresh.setOnClickListener {
            initData()
            graphView.values = values
            //graphView.invalidate()
        }
    }

    private fun initData() {
        values = ArrayList<Int>()

        val random = java.util.Random()
        for(index in 0..(Math.abs(random.nextInt()) % 10)) {
            values.add( Math.abs(random.nextInt()) % 101)
        }
    }
}