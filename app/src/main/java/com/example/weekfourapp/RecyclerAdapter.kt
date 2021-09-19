 package com.example.weekfourapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    // Declaring list of all items needed to be displayed
    var celebrantName= arrayOf("Christan Ronaldo","Lionel Merci","David Union","Xavi Boyle",
        "Kelechi Iheanacho","Wilfred Ndidi","Samuel Fun","Frank Omo",)

    var celebrantDob= arrayOf("1/3/1988","10/2/1888","5/6/1994","1/3/1992","10/8/1877","11/12/2001"
        ,"10/12/1990","12/12/1998")

    var daysLeft= arrayOf("23 days left","3 days left","5 days left","10 days left","20 days left","50 days left",
        "34 days left","32 days left",)

    var img= intArrayOf(R.drawable.ronaldo,R.drawable.messi2,R.drawable.david,R.drawable.xavi,R.drawable.kelechi,R.drawable.ndidi,
        R.drawable.samuel,R.drawable.frank)

    var longBar= intArrayOf(R.drawable.bar_one,R.drawable.bar_two,R.drawable.bar_three,R.drawable.bar_four,R.drawable.bar_one
        ,R.drawable.bar_two,R.drawable.bar_three,R.drawable.bar_four)




   inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

       var name: TextView
       var dob: TextView
       var days: TextView
       var img: ImageView
       var bar: ImageView

       init{
           name= itemView.findViewById(R.id.name)
           dob= itemView.findViewById(R.id.dob)
           days= itemView.findViewById(R.id.days)
           img= itemView.findViewById(R.id.image_image)
           bar= itemView.findViewById(R.id.long_bar)
       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.upcoming_birthday,parent,false)
         return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text= celebrantName[position]
        holder.dob.text= celebrantDob[position]
        holder.days.text= daysLeft[position]
        holder.img.setImageResource(img[position])
        holder.bar.setImageResource(longBar[position])

    }

    override fun getItemCount(): Int {
        return celebrantName.size

    }
}