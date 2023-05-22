package com.pavluyk.coin_presentation.viewmodel


import androidx.lifecycle.LiveData
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


    private var isLoading = false


    init {
        viewModelScope.launch {
            isLoading = true
            coinDataLiveData.value = fetchDataUseCase.execute()
            isLoading = false
        }
    }

    fun onPagination() {
        if (isLoading.not()) {
            viewModelScope.launch {
                isLoading = true
                val currentList = coinDataLiveData.value ?: emptyList()
                coinDataLiveData.value = if (currentList.isNotEmpty()) {
                    currentList + fetchDataUseCase.execute(currentList.last().rank)
                } else {
                    fetchDataUseCase.execute()
                }
                isLoading = false
            }
        }
    }
}