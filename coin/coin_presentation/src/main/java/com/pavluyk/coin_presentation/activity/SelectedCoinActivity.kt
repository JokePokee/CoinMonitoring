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

    lateinit var tvSelectedCoin: TextView
    lateinit var ivSelectedCoin: ImageView
    lateinit var tvDetailedInfo: TextView

    private val viewModel: CoinDetailedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_coin)
        ivSelectedCoin = findViewById(R.id.ivSelectedCoin)
        tvSelectedCoin = findViewById(R.id.tvSelectedCoin)
        tvDetailedInfo = findViewById(R.id.tvDetailedInfo)

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