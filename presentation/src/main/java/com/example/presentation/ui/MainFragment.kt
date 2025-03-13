package com.example.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.presentation.R
import com.example.presentation.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentMainBinding.bind(view)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}