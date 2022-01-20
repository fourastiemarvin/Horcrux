package com.example.horcrux.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horcrux.network.HorcruxApi
import com.example.horcrux.network.HorcruxApiFilter
import com.example.horcrux.network.HorcruxProperty
import kotlinx.coroutines.launch

enum class HorcruxApiStatus { LOADING, ERROR, DONE }

class HomeViewModel(): ViewModel() {

    private val _status = MutableLiveData<HorcruxApiStatus>()

    val status: LiveData<HorcruxApiStatus>
        get() = _status

    private val _response = MutableLiveData<List<HorcruxProperty>>()

    val response: LiveData<List<HorcruxProperty>>
        get() = _response

    init {
        getHorcruxProperties(HorcruxApiFilter.SHOW_ALL)
    }


    private fun getHorcruxProperties(filter: HorcruxApiFilter) {
        viewModelScope.launch {
            _status.value = HorcruxApiStatus.LOADING
            try {
                _response.value = HorcruxApi.retrofitService.getProperties(filter.value)
                _status.value = HorcruxApiStatus.DONE
            } catch (e: Exception) {
                _status.value = HorcruxApiStatus.ERROR
                _response.value = ArrayList()
            }
        }
    }
}
