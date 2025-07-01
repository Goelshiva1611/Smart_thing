package com.example.smarthome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

data class Device(val icon: Int, val name: String, var isOn: Boolean)

class DeviceAdapter(private val devices: List<Device>) :
    RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>() {

    inner class DeviceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.deviceIcon)
        val name: TextView = itemView.findViewById(R.id.deviceName)
        val status: TextView = itemView.findViewById(R.id.deviceStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_device, parent, false)
        return DeviceViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        val device = devices[position]
        holder.name.text = device.name
        holder.status.text = if (device.isOn) "On" else "Off"

        holder.icon.setImageResource(device.icon)
        holder.icon.background = ContextCompat.getDrawable(
            holder.itemView.context,
            if (device.isOn) R.drawable.circle_background_dark else R.drawable.circle_background_light
        )

        holder.itemView.setOnClickListener {
            device.isOn = !device.isOn
            notifyItemChanged(position)
        }
    }

    override fun getItemCount() = devices.size
}
