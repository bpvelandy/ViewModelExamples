package com.bpv.vmapplication.normal.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bpv.vmapplication.databinding.FragmentThreeBinding
import com.bpv.vmapplication.normal.vm.DefaultViewModel

class ThreeFragment : Fragment() {

    private val viewModel by viewModels<DefaultViewModel>()

    private var _binding: FragmentThreeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAdd.setOnClickListener {
            viewModel.addData(
                binding.edInputTitle.text.toString(),
                binding.edInputNumber.text.toString().toIntOrNull(),
                binding.edInputDesc.text.toString()
            )
            binding.edInputTitle.text.clear()
            binding.edInputNumber.text.clear()
            binding.edInputDesc.text.clear()
        }
        binding.btnPrevious.setOnClickListener {
            findNavController().navigateUp()
        }
        viewModel.listOfDataLiveData.observe(viewLifecycleOwner, {
            binding.tvContent.text = it.joinToString("\n")
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}