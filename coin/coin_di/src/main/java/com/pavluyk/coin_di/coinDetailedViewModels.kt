package com.pavluyk.coin_di

import android.os.Bundle
import com.pavluyk.coin_presentation.activity.DetailedCoinFragment.Companion.ARG_ID
import com.pavluyk.coin_presentation.viewmodel.CoinDetailedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coinDetailedViewModels = module {
    viewModel { (bundle: Bundle?) ->
        CoinDetailedViewModel(fetchDetailedData = get(), id = bundle?.getString(ARG_ID) ?: "")
    }
}