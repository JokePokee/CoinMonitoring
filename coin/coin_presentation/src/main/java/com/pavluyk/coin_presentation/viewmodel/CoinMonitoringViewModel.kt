package com.pavluyk.coin_presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavluyk.coin_domain.models.CoinModel
import com.pavluyk.coin_domain.usecases.FetchDataUseCase
import kotlinx.coroutines.launch

class CoinMonitoringViewModel(
    private val fetchDataUseCase: FetchDataUseCase
) : ViewModel() {

    var coinDataLiveData = MutableLiveData<List<CoinModel>>()
    var openSelectedCoinActivity = MutableLiveData<String>()

    var isLoading = false


    init {
        viewModelScope.launch { coinDataLiveData.value = fetchDataUseCase.execute() }
    }

    fun onPagination() {
        if (isLoading.not()) {
            viewModelScope.launch {
                isLoading = true
                val currentList = coinDataLiveData.value ?: emptyList()
                if (currentList.isNotEmpty()) {
                    coinDataLiveData.value =
                        currentList + fetchDataUseCase.execute(currentList.last().rank)
                } else {
                    fetchDataUseCase.execute()
                }
                isLoading = false
            }
        }
    }

    fun onItemClicked(symbol: String) {
        openSelectedCoinActivity.value = symbol
    }

}