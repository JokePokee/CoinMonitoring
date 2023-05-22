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
    val adapter = CoinMonitoringAdapter(
        clickListener = { symbol ->
            startActivity(
                Intent(this, SelectedCoinActivity::class.java).putExtra(
                    "minModel",
                    symbol
                )
            )
        },
        onScrolledToBottom = {
            viewModel.onPagination()
        })

    private val viewModel: CoinMonitoringViewModel by viewModel()
    val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvCoin).apply {
            adapter = this@CoinMonitoringActivity.adapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this@CoinMonitoringActivity)

        viewModel.coinDataLiveData.observe(this, Observer {
            it?.let { adapter.setData(it) }
        })

    }
}