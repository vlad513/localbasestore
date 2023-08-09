package com.vladv.localbasestore.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.vladv.localbasestore.R
import com.vladv.localbasestore.databinding.FragmentMainBinding
import com.vladv.localbasestore.presentation.main.adapter.AdapterMain
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    private val viewModel by viewModel<MainViewModel>()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        AdapterMain()
    }
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcView.adapter = adapter
        viewModel.getRecord()

        lifecycleScope.launchWhenCreated {
            viewModel.recordByFlow.collect {
                adapter.addRepoz(it)
            }
        }


        binding.toolbar.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.add -> {
                        findNavController().navigate(R.id.action_mainFragment_to_addDataFragment)
                        true
                    }

                    R.id.sort -> {
                        findNavController().navigate(R.id.action_mainFragment_to_dialogFragment)
                        true
                    }
                    R.id.firestore -> {
                        findNavController().navigate(R.id.action_mainFragment_to_fireStoreFragment)
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }



}