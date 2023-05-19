package com.pavluyk.coin_di

import com.pavluyk.coin_presentation.viewmodel.CoinDetailedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coinDetailedViewModels = module {
    viewModel{
        CoinDetailedViewModel(get())
    }
}