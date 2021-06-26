package com.bpv.vmapplication.normal.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bpv.vmapplication.R
import com.bpv.vmapplication.databinding.FragmentTwoBinding
import com.bpv.vmapplication.normal.vm.DefaultViewModel

class TwoFragment : Fragment() {

    private val viewModel by viewModels<DefaultViewModel>()

    private var _binding: FragmentTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTwoBinding.inflate(inflater, container, false)
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
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_twoFragment_to_threeFragment)
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