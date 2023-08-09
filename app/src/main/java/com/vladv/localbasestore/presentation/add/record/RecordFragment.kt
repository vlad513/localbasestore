package com.vladv.localbasestore.presentation.add.record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.vladv.domain.model.ModelRecord
import com.vladv.localbasestore.R
import com.vladv.localbasestore.databinding.FragmentRecordBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class RecordFragment : Fragment() {
    private val viewModel by viewModel<RecordViewModel>()
    private lateinit var binding: FragmentRecordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getProbe()
        viewModel.getUnit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonSave.setOnClickListener {
            when {
                binding.autoCompleteTextView.text.isNullOrEmpty() -> {
                    binding.include2.constraintError.visibility = View.VISIBLE
                }

                binding.autoCompleteTextView2.text.isNullOrEmpty() -> {
                    binding.include2.constraintError.visibility = View.VISIBLE
                }

                binding.edValue.text.isNullOrEmpty() -> {
                    binding.include2.constraintError.visibility = View.VISIBLE
                }

                binding.edNumberRecord.text.isNullOrEmpty() -> {
                    binding.include2.constraintError.visibility = View.VISIBLE
                }

                binding.edTimestamp.text.isNullOrEmpty() -> {
                    binding.include2.constraintError.visibility = View.VISIBLE
                }

                else -> {
                    viewModel.saveRecord(
                        ModelRecord(
                            id = 0,
                            timestamp = binding.edTimestamp.text.toString().toInt(),
                            numberRecord = binding.edNumberRecord.text.toString().toInt(),
                            value = binding.edValue.text.toString().toInt(),
                            idUnit = binding.autoCompleteTextView.text.toString().toInt(),
                            idProbe = binding.autoCompleteTextView2.text.toString().toInt()
                        )
                    )
                    binding.autoCompleteTextView.text?.clear()
                    binding.autoCompleteTextView2.text?.clear()
                    binding.edTimestamp.text?.clear()
                    binding.edNumberRecord.text?.clear()
                    binding.edValue.text?.clear()
                    binding.include2.constraintError.visibility = View.GONE
                }
            }

        }

        lifecycleScope.launchWhenCreated {
            viewModel.probeByFlow.collect {
                val arrayAdapter = ArrayAdapter(
                    requireContext(),
                    R.layout.dropdown_item,
                    it
                )
                binding.autoCompleteTextView2.setAdapter(arrayAdapter)
            }
        }
        lifecycleScope.launchWhenCreated {
            viewModel.unitByFlow.collect {
                val arrayAdapter = ArrayAdapter(
                    requireContext(),
                    R.layout.dropdown_item,
                    it
                )
                binding.autoCompleteTextView.setAdapter(arrayAdapter)
            }
        }
    }
}