package com.example.viewmodel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentSubBinding
import com.example.viewmodel.util.UiState
import kotlinx.coroutines.launch

class SubFragment : Fragment() {
    private val binding by lazy {
        FragmentSubBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: TextViewModel
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
                    binding.editTextFromFragment2.setText(it.data)
                }
                is UiState.Failure -> {
                    Toast.makeText(requireContext(), "fail to change text", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.sendButtonFragment2.setOnClickListener {
            val text = binding.editTextFromFragment2.text.toString()
            viewModel.getChangeText(text)
        }

        return binding.root
    }
}