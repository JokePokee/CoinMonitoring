package com.pavluyk.coin_presentation.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavluyk.coin_domain.models.CoinModel
import com.pavluyk.coin_domain.usecases.FetchCoinUseCase
import com.pavluyk.coin_domain.usecases.ObserveCoinsUseCase
import com.pavluyk.coin_domain.usecases.RemoveCoinsUseCase
import com.pavluyk.coinmonitortest.SingleLiveEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class CoinMonitoringViewModel(
    private val fetchCoinUseCase: FetchCoinUseCase,
    private val removeCoinsUseCase: RemoveCoinsUseCase,
    private val observeCoinsUseCase: ObserveCoinsUseCase
) : ViewModel() {

    val coinDataLiveData = MutableLiveData<List<CoinModel>>()

    val navigationEvent = SingleLiveEvent<Navigation>()

    private var isLoading = false

    init {
        removeAllCoinFromDb()
        observeCoins()
        initialFetchCoins()
    }

    private fun initialFetchCoins() {
        viewModelScope.launch {
            isLoading = true
            delay((2L).seconds)
            fetchCoinUseCase.fetchCoins()
            isLoading = false
        }
    }

    private fun removeAllCoinFromDb() {
        viewModelScope.launch {
            removeCoinsUseCase.removeAllCoins()
        }
    }

    fun onCoinClicked(id: String) {
        navigationEvent.value = Navigation.ToDetailedFragment(id)
    }

    private fun observeCoins() {
        observeCoinsUseCase.observeCoins()
            .onEach {
                coinDataLiveData.value = it
            }.launchIn(viewModelScope)
    }

    fun onPagination() {
        if (isLoading.not()) {
            viewModelScope.launch {
                isLoading = true
                val currentList = coinDataLiveData.value ?: emptyList()
                if (currentList.isNotEmpty()) {
                    fetchCoinUseCase.fetchCoins(currentList.last().rank)
                } else {
                    fetchCoinUseCase.fetchCoins()
                }
                isLoading = false
            }
        }
    }

    sealed interface Navigation {
        data class ToDetailedFragment(var id: String) : Navigation
    }
}