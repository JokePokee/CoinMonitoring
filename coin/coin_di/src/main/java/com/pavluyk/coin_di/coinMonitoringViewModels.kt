package com.pavluyk.coin_di

import com.pavluyk.coin_presentation.viewmodel.CoinMonitoringViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coinMonitoringViewModels = module {
    viewModel{
        CoinMonitoringViewModel(get())

    }
}