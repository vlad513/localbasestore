package com.vladv.localbasestore.presentation.add.probe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladv.domain.model.ModelProbe
import com.vladv.localbasestore.databinding.FragmentProbeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProbeFragment : Fragment() {
    private val viewModel by viewModel<ProbeViewModel>()
    private lateinit var binding: FragmentProbeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProbeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSave.setOnClickListener {

            when {
                binding.edText.text.isNullOrEmpty() -> {
                    binding.include2.constraintError.visibility = View.VISIBLE
                }

                binding.edText2.text.isNullOrEmpty() -> {
                    binding.include2.constraintError.visibility = View.VISIBLE
                }

                else -> {
                    viewModel.saveProbe(
                        ModelProbe(
                            0,
                            binding.edText.text.toString(),
                            binding.edText2.text.toString()
                        )
                    )
                    binding.edText.text?.clear()
                    binding.edText2.text?.clear()
                    binding.include2.constraintError.visibility = View.GONE
                }
            }
        }
    }
}