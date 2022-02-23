package com.example.horcrux

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.horcrux.databinding.FragmentHomeBinding
import com.example.horcrux.viewModels.HomeViewModel

class HomeFragment: Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentHomeBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        viewModel.response.observe(viewLifecycleOwner){
            if (null != it) {
                binding.getCharButton.setOnClickListener (
                    Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_characterFragment))
            }
        }
        return binding.root
    }
}