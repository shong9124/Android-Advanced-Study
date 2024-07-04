package com.example.viewmodel.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentMainBinding
import com.example.viewmodel.util.UiState

class MainFragment : Fragment() {
    private val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel : TextViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(TextViewModel::class.java)

        viewModel.textState.observe(viewLifecycleOwner, Observer {
            when(it) {
                is UiState.Loading -> {
                    Toast.makeText(requireContext(), "loading...", Toast.LENGTH_SHORT).show()
                }
                is UiState.Success -> {
                    binding.editTextFromFragment1.setText(it.data)
                }
                is UiState.Failure -> {
                    Toast.makeText(requireContext(), "fail to change text", Toast.LENGTH_SHORT).show()
                }
            }

            binding.sendButtonFragment1.setOnClickListener {
                val text = binding.editTextFromFragment1.text.toString()
                viewModel.getChangeText(text)
            }
        })

        return binding.root
    }
}