package com.pavluyk.coin_presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavluyk.coin_presentation.R
import com.pavluyk.coin_presentation.adapter.CoinMonitoringAdapter
import com.pavluyk.coin_presentation.viewmodel.CoinDetailedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectedCoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_coin)
    }
}