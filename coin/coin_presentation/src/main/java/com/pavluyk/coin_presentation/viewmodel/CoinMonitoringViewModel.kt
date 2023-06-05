package com.pavluyk.coin_presentation.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavluyk.coin_domain.models.CoinModel
import com.pavluyk.coin_domain.usecases.FetchDataUseCase
import com.pavluyk.coinmonitortest.SingleLiveEvent
import kotlinx.coroutines.launch

class CoinMonitoringViewModel(
    private val fetchData: FetchDataUseCase
) : ViewModel() {

    val coinDataLiveData = MutableLiveData<List<CoinModel>>()

    val navigationEvent = SingleLiveEvent<Navigation>()

    private var isLoading = false


    init {
        viewModelScope.launch {
            isLoading = true
            coinDataLiveData.value = fetchData.execute()
            isLoading = false
        }
    }

    fun onCoinClicked(id: String) {
        navigationEvent.value = Navigation.ToDetailedFragment(id)
    }

    fun onPagination() {
        if (isLoading.not()) {
            viewModelScope.launch {
                isLoading = true
                val currentList = coinDataLiveData.value ?: emptyList()
                coinDataLiveData.value = if (currentList.isNotEmpty()) {
                    currentList + fetchData.execute(currentList.last().rank)
                } else {
                    fetchData.execute()
                }
                isLoading = false
            }
        }
    }

    sealed interface Navigation {
        data class ToDetailedFragment(var id: String) : Navigation
    }

}