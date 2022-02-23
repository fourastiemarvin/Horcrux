package com.example.horcrux.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horcrux.network.HorcruxApi
import com.example.horcrux.network.HorcruxApiFilter
import com.example.horcrux.network.HorcruxProperty
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList
import kotlin.random.Random

enum class HorcruxApiStatus { LOADING, ERROR, DONE }

class HomeViewModel(): ViewModel() {

    private val _status = MutableLiveData<HorcruxApiStatus>()

    val status: LiveData<HorcruxApiStatus>
        get() = _status

    private val _response = MutableLiveData<List<HorcruxProperty>>()

    val response: LiveData<List<HorcruxProperty>>
        get() = _response

    private var _randomCharacter = MutableLiveData<HorcruxProperty>()

    val randomCharacter: LiveData<HorcruxProperty>
        get() = _randomCharacter

    init {
        getHorcruxProperties(HorcruxApiFilter.SHOW_ALL)
    }


    private fun getHorcruxProperties(filter: HorcruxApiFilter) {
        viewModelScope.launch {
            _status.value = HorcruxApiStatus.LOADING
            try {
                _response.value = HorcruxApi.retrofitService.getAllCharacters(filter.value)
                _status.value = HorcruxApiStatus.DONE
                getRandomChar()
            } catch (e: Exception) {
                _status.value = HorcruxApiStatus.ERROR
                _response.value = ArrayList()
            }
        }
    }


    private fun getRandomChar() {
        val randInt = _response.value?.let { Random.nextInt(0, it.size) }
        _randomCharacter.value = randInt?.let { _response.value?.get(it) }
    }
}
