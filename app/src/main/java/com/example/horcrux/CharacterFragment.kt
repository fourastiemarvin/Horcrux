package com.example.horcrux

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.horcrux.databinding.FragmentCharacterBinding
import com.example.horcrux.viewModels.HomeViewModel


class CharacterFragment: Fragment() {

private val viewModel: HomeViewModel by lazy {
    ViewModelProvider(this).get(HomeViewModel::class.java)
}

        override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//
        val binding = FragmentCharacterBinding.inflate(inflater)

        viewModel.randomCharacter.observe(viewLifecycleOwner) {
            binding.textView.text = viewModel.randomCharacter.value?.name
        }
//  TODO: add a image view

//        binding.lifecycleOwner = viewLifecycleOwner
//
//        binding.viewModel = viewModel
////        binding.viewModel = ViewModelProvider(
////            this).get(CharacterViewModel::class.java)
//
////        viewModel.selectedCharacter.observe(viewLifecycleOwner) {
////            if (null != it) {
////                Picasso.get().load(viewModel.selectedCharacter.value?.image).into(binding.imageView)
////            }
////        }
//
//
//
        return binding.root
    }
}