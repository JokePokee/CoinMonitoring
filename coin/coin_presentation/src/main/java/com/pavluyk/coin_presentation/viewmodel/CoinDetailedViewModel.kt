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
import com.pavluyk.coin_presentation.activity.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoinDetailedViewModel(
    private val fetchDetailedDataUseCase: FetchDetailedDataUseCase
) : ViewModel() {

    var coinDetailedLiveData = MutableLiveData<CoinDetailed>()

    fun getDetailedData(symbol: String) {
        viewModelScope.launch {
            coinDetailedLiveData.value = fetchDetailedDataUseCase.execute(symbol)
        }

    }


}