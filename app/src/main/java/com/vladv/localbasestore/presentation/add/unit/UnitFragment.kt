package com.vladv.localbasestore.presentation.add.unit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.vladv.domain.model.ModelUnit
import com.vladv.localbasestore.R
import com.vladv.localbasestore.databinding.FragmentUnitBinding

import org.koin.androidx.viewmodel.ext.android.viewModel


class UnitFragment : Fragment() {
    private val viewModel by viewModel<ViewModelUnit>()
    private lateinit var binding: FragmentUnitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUnitBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayAdapter = ArrayAdapter(
            requireContext(),
            R.layout.dropdown_item,
            resources.getStringArray(R.array.temp)
        )
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
        binding.buttonSave.setOnClickListener {
            when {
                binding.autoCompleteTextView.text.isNullOrEmpty() -> {
                    binding.include2.constraintError.visibility = View.VISIBLE
                }

                else -> {
                    viewModel.saveUnit(
                        ModelUnit(
                            0,
                            binding.autoCompleteTextView.text.toString()
                        )
                    )
                    binding.autoCompleteTextView.text.clear()
                    binding.include2.constraintError.visibility = View.GONE

                }
            }
        }
    }
}