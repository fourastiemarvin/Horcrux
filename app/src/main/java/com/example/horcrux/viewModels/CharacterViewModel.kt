package com.example.horcrux.viewModels

// TODO: Is this Character view model useful ?

//import android.app.Application
//import android.util.Log
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.example.horcrux.network.HorcruxProperty
//import kotlin.random.Random
//
////enum class HorcruxApiStatus { LOADING, ERROR, DONE }
//
////class CharacterViewModel(horcruxProperty: HorcruxProperty, application: Application): AndroidViewModel(application) {
//class CharacterViewModel(): ViewModel() {
//
//    private val _horcruxProperty = MutableLiveData<HorcruxProperty>()
//
//    val horcruxProperty: String?
//        get() = _horcruxProperty.value?.name
////    private val _homeViewModel = HomeViewModel()
//
////    private val _allCharacters = MutableLiveData<List<HorcruxProperty>>()
////
////    private val _selectedCharacter = MutableLiveData<HorcruxProperty>()
////
////    private val allCharacters: LiveData<List<HorcruxProperty>>
////        get() = _allCharacters
////
////    val selectedCharacter: LiveData<HorcruxProperty>
////        get() = _selectedCharacter
////
//    init {
//        Log.i("prop", horcruxProperty.toString())
////        _allCharacters.value = _homeViewModel.response.value
////        Log.i("all", _allCharacters.value.toString())
////        Log.i("horcrux", horcruxProperty.name)
////        val randomChar = allCharacters.value?.let { Random.nextInt(0, it.size) }
////        Log.i("rand", randomChar.toString())
////        _selectedCharacter.value = randomChar?.let { _allCharacters.value?.get(it) }
////        Log.i("char", _selectedCharacter.value.toString())
//    }
//
//}