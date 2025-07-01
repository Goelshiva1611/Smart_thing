package com.example.smarthome

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DeviceAdapter
    private lateinit var tabMy: TextView
    private val deviceList = mutableListOf<Device>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.deviceRecycler)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        tabMy = findViewById(R.id.tabMy)

        adapter = DeviceAdapter(deviceList)
        recyclerView.adapter = adapter

        tabMy.setOnClickListener {
            loadDevices()
        }
    }

    private fun loadDevices() {
        deviceList.clear()
        deviceList.addAll(
            listOf(
                Device(R.drawable.ic_lightbulb, "Desk light", true),
                Device(R.drawable.ic_ceiling_lamp, "Globe", false),
                Device(R.drawable.ic_security, "Security", true),
                Device(R.drawable.ic_coffee, "Coffee", true),
                Device(R.drawable.ic_tv, "TV", false)
            )
        )
        adapter.notifyDataSetChanged()
    }
}
