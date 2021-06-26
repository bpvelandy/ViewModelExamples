package com.bpv.vmapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bpv.vmapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnActivityShareVm.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_oneShareFragment3)
        }
        binding.btnNavShareVm.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_oneNavShareFragment)
        }
        binding.btnNormalShareVm.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_oneFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}