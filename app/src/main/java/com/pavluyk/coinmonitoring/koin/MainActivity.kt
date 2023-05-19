package com.pavluyk.coinmonitoring.koin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavluyk.coin_presentation.activity.CoinMonitoringActivity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, CoinMonitoringActivity::class.java))
    }
}