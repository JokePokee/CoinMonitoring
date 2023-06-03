package com.pavluyk.coin_presentation.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavluyk.coin_domain.models.CoinDetailed
import com.pavluyk.coin_domain.usecases.FetchDetailedDataUseCase
import kotlinx.coroutines.launch

class CoinDetailedViewModel(
    private val fetchDetailedDataUseCase: FetchDetailedDataUseCase,
    val id: String
) : ViewModel() {

    var coinDetailedLiveData = MutableLiveData<CoinDetailed>()

    init {
        getDetailedData(id)
    }

    private fun getDetailedData(id: String) {
        viewModelScope.launch {
            coinDetailedLiveData.value = fetchDetailedDataUseCase.execute(id)
        }

    }


}