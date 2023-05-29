package com.pavluyk.coin_presentation.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.pavluyk.coin_presentation.R
import com.pavluyk.coin_presentation.viewmodel.CoinDetailedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectedCoinActivity : AppCompatActivity() {

    private val tvSelectedCoin by lazy {
        findViewById<TextView>(R.id.tvSelectedCoin)
    }
    private val ivSelectedCoin by lazy {
        findViewById<ImageView>(R.id.ivSelectedCoin)
    }
    private val tvDetailedInfo by lazy {
        findViewById<TextView>(R.id.tvDetailedInfo)
    }

    private val viewModel: CoinDetailedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_coin)

        val receive = intent.getStringExtra("minModel")
        receive?.let { viewModel.getDetailedData(it) }

        viewModel.coinDetailedLiveData.observe(this, Observer { coinDetailed ->
            val coinDetailed = coinDetailed
            coinDetailed
            tvSelectedCoin.text = coinDetailed.name
            tvDetailedInfo.text = coinDetailed.assetDescription
            Glide.with(this).load(coinDetailed.logoUrl).into(ivSelectedCoin)

        })
    }
}