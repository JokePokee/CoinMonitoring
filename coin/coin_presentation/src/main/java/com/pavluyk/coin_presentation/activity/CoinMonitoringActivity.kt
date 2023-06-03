package com.pavluyk.coin_presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavluyk.coin_presentation.R
import com.pavluyk.coin_presentation.adapter.CoinMonitoringAdapter
import com.pavluyk.coin_presentation.viewmodel.CoinDetailedViewModel
import com.pavluyk.coin_presentation.viewmodel.CoinMonitoringViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CoinMonitoringActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}