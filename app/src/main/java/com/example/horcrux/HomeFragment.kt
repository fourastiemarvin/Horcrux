package com.example.horcrux

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.horcrux.databinding.FragmentHomeBinding
import com.example.horcrux.viewModels.HomeViewModel
import com.squareup.picasso.Picasso

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

        viewModel.response.observe(viewLifecycleOwner, {
            if (null != it) {
                Picasso.get().load(viewModel.response.value?.get(0)?.image).into(binding.imageView)
            }
        })

        return binding.root
    }
}