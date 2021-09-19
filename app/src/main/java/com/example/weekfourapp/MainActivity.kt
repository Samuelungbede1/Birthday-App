package com.example.weekfourapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {

    //Initializing field variables for viewpager2
    private lateinit var viewPagerImgSlider: ViewPager2
    private lateinit var slideItemList: ArrayList<SliderItem>
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var sliderHandler: Handler
    private lateinit var sliderRun : Runnable

    //initialising field variables for recycler view
    lateinit var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
    lateinit var layoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //layout manager works with the recycler view
        layoutManager= LinearLayoutManager(this)
        var recyclerView= findViewById<RecyclerView>(R.id.rvbirthday)
        recyclerView.layoutManager= layoutManager
        adapter=RecyclerAdapter()
        recyclerView.adapter=adapter
        viewPagerImgSlider = findViewById(R.id.viewPagerImgSlider)


        //this two functions when called will execute the sliding
        sliderItems()
        itemSliderView()
    }


    //Function that carries out the sliding action
    private fun sliderItems() {
        slideItemList= ArrayList()
        sliderAdapter= SliderAdapter(viewPagerImgSlider,slideItemList)
        viewPagerImgSlider.adapter=sliderAdapter
        viewPagerImgSlider.clipToPadding=false
        viewPagerImgSlider.clipChildren=false
        viewPagerImgSlider.offscreenPageLimit=3
        viewPagerImgSlider.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER



        //this wil animate our sliding view
        val comPosTarn= CompositePageTransformer()
        comPosTarn.addTransformer(MarginPageTransformer(40))

        comPosTarn.addTransformer{page, position->
            var r: Float=1- kotlin.math.abs(position)
            page.scaleY=0.85f+ r*0.15f
        }


        viewPagerImgSlider.setPageTransformer(comPosTarn)
        sliderHandler= Handler()
        sliderRun= Runnable{
        viewPagerImgSlider.currentItem=viewPagerImgSlider.currentItem+1
        }

        viewPagerImgSlider.registerOnPageChangeCallback(
            object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected (position: Int) {
                    super.onPageSelected(position)
                    sliderHandler.removeCallbacks(sliderRun)
                    sliderHandler.postDelayed(sliderRun,2000)


                }
            }
        )
    }
    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRun)

    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRun,2000)
    }


    //This is the function that will populate our items list

    private fun itemSliderView() {
        slideItemList.add(SliderItem(R.drawable.messi2, "Christian"))
        slideItemList.add(SliderItem(R.drawable.messi3, "Lionel"))
        slideItemList.add(SliderItem(R.drawable.messi4, "David"))
        slideItemList.add(SliderItem(R.drawable.messi5, "Iniester"))
        slideItemList.add(SliderItem(R.drawable.messi6, "Kelechi"))
        slideItemList.add(SliderItem(R.drawable.messi7, "Wilfred"))
        slideItemList.add(SliderItem(R.drawable.messi8, "Samuel"))
        slideItemList.add(SliderItem(R.drawable.messi9, "Frank"))
        slideItemList.add(SliderItem(R.drawable.messi_1, "Godday"))
        slideItemList.add(SliderItem(R.drawable.messi_2, "Joeseph"))
        slideItemList.add(SliderItem(R.drawable.messi_3, "Tolu"))
        slideItemList.add(SliderItem(R.drawable.messi_4, "Samuel"))
        slideItemList.add(SliderItem(R.drawable.messi_5, "Osehi"))
        slideItemList.add(SliderItem(R.drawable.messi_6, "Daniel"))
    }
}