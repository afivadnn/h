package com.afivadnan.h
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    private val fragmentList = arrayOf(FirstFragment(), SecondFragment(), ThirdFragment())

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    fun getFragmentAt(position: Int): Fragment {
        return fragmentList[position]
    }
}
