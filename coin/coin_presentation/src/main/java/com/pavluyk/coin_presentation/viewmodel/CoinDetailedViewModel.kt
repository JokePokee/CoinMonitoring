package com.pavluyk.coin_presentation.viewmodel

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavluyk.coin_domain.models.CoinDetailed
import com.pavluyk.coin_domain.models.CoinModel
import com.pavluyk.coin_domain.usecases.FetchDetailedDataUseCase
import com.pavluyk.coin_presentation.activity.SelectedCoinActivity
import kotlinx.coroutines.launch

class CoinDetailedViewModel(
    private val fetchDetailedDataUseCase: FetchDetailedDataUseCase
) : ViewModel() {

    var coinDetailedLiveData = MutableLiveData<List<CoinDetailed>>()


    fun getDetailedData(symbol: String) {
        viewModelScope.launch {
            val currentList = coinDetailedLiveData.value ?: emptyList()
            if (currentList.isEmpty()) {
                currentList + fetchDetailedDataUseCase.execute(symbol)
            } else {
                fetchDetailedDataUseCase.execute()
            }
        }
    }


}