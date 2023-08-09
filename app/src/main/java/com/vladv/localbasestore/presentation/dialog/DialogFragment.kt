package com.vladv.localbasestore.presentation.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.vladv.localbasestore.R
import com.vladv.localbasestore.databinding.FragmentDialogBinding
import com.vladv.localbasestore.presentation.dialog.adapter.AdapterDialog
import org.koin.androidx.viewmodel.ext.android.viewModel


class DialogFragment : DialogFragment() {

    private val viewModel by viewModel<DialogViewModel>()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        AdapterDialog()
    }
    private lateinit var binding: FragmentDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcView.adapter = adapter
        lifecycleScope.launchWhenCreated {
            viewModel.probeByFlow.collect {
                adapter.addRepoz(it)
            }
        }
        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_dialogFragment_to_mainFragment)
        }
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_dialogFragment_to_mainFragment)
        }
    }

}