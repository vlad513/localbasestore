package com.vladv.localbasestore.presentation.add.vpadapter

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vladv.localbasestore.presentation.add.probe.ProbeFragment
import com.vladv.localbasestore.presentation.add.record.RecordFragment
import com.vladv.localbasestore.presentation.add.unit.UnitFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                RecordFragment()
            }

            1 -> {
                UnitFragment()
            }

            2 -> {
                ProbeFragment()
            }

            else -> {
                throw Resources.NotFoundException("Position Not Found")
            }
        }
    }
}