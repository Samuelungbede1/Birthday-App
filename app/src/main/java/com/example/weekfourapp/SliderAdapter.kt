package com.example.weekfourapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class SliderAdapter(var viewPager: ViewPager2, val dataOfcelebrant: ArrayList<SliderItem>) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {


    //inner class contains variables that are attached to our view elements in the layout
    inner class SliderViewHolder(var value: View) : RecyclerView.ViewHolder(value) {
        val imge = value.findViewById<ImageView>(R.id.imageSlider)
        var name = value.findViewById<TextView>(R.id.who)
    }


    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): SliderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflated = inflater.inflate(R.layout.slide_item, parent, false)
        return SliderViewHolder(inflated)
    }

    override fun onBindViewHolder (holder: SliderViewHolder, position: Int) {
        val data = dataOfcelebrant[position]
        holder.name.text = String.format("it is ${data.name}'s Birthday")
        holder.imge.setImageResource(data.img)
        if (position == dataOfcelebrant.size - 2) {
            viewPager.post(run)
        }
    }

    private val run = Runnable {
        dataOfcelebrant.addAll(dataOfcelebrant)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataOfcelebrant.size
}