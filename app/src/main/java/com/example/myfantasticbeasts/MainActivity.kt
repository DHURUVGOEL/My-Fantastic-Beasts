package com.example.myfantasticbeasts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.android.car.ui.toolbar.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager2)
        val adapter = FragmentAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> {
                    "Animals"
                }
                1 -> {
                    "Birds"
                }
                2 -> {
                    "Plants"
                }
                else -> {
                    "Animals"
                }
            }
        }.attach()
    }
}
//    private fun setupTabLayout(){
//        TabLayoutMediator(
//            binding.tabLayout,binding.viewPager2
//        ) {tab,position-> tab.text = "Tab"+(position +1)}.attach()
//    }
//    private fun setupViewPager2() {
//        val adapter = FragmentAdapter(this, 3)
//        binding.viewPager2.adapter = adapter
//    }

//        tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                val viewPager = binding.vie
//               if(tab != null){
//                   viewPager2.currentItem = tab.position
//               }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//            }
//
//        })
//    viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
//             override fun onPageSelected(position: Int) {
//                 super.onPageSelected(position)
//                 tabLayout.selectTab(tabLayout.getTabAt(position))
//
//             }
//    })


////         var tabLayout: TabLayout = findViewById(R.id.tabLayout) as TabLayout
////         var viewPager2: ViewPager2 = findViewById(R.id.viewPager2) as ViewPager2
//
//
//        val fragments = listOf(
//            AnimalsFragment(),
//            BirdsFragment(),
//            PlantsFragment()
//        )
//
//          adapter = FragmentAdapter(supportFragmentManager,lifecycle)
//         tabLayout.addTab(tabLayout.newTab().setText("Animals"))
//         tabLayout.addTab(tabLayout.newTab().setText("Birds"))
//         tabLayout.addTab(tabLayout.newTab().setText("Plants"))
//
//        viewPager2.adapter= adapter
//        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
//            when (position) {
//                0 -> tab.text = "Tab 1"
//                1 -> tab.text = "Tab 2"
//                2 -> tab.text = "Tab 3"
//            }
//        }.attach()
//
//        tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//               if(tab != null){
//                   viewPager2.currentItem = tab.position
//               }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//            }
//
//        })
//         viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
//             override fun onPageSelected(position: Int) {
//                 super.onPageSelected(position)
//                 tabLayout.selectTab(tabLayout.getTabAt(position))
//
//             }
//         })
//

