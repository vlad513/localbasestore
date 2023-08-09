package com.vladv.localbasestore.presentation.add

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.vladv.localbasestore.R
import com.vladv.localbasestore.databinding.FragmentAddDataBinding
import com.vladv.localbasestore.presentation.add.vpadapter.ViewPagerAdapter


class AddDataFragment : Fragment() {
    private lateinit var binding: FragmentAddDataBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddDataBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.materialToolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_addDataFragment_to_mainFragment)
        }
        binding.viewPager.adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.setCurrentItem(0, false)
        TabLayoutMediator(binding.tablayout, binding.viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "Record"
                }

                1 -> {
                    "Unit"
                }

                2 -> {
                    "Probe"
                }

                else -> {
                    throw Resources.NotFoundException("Position Not Found")
                }
            }
        }.attach()
    }

}