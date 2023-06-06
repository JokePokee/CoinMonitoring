package com.pavluyk.coinmonitoring.coin

import android.app.Application
import com.pavluyk.coin_di.appModule
import com.pavluyk.coin_di.coinDetailedModule
import com.pavluyk.coin_di.coinDetailedViewModels
import com.pavluyk.coin_di.coinMonitoringModule
import com.pavluyk.coin_di.coinMonitoringViewModels
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class CoinApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CoinApplication)
            modules(
                coinMonitoringModule,
                coinDetailedModule,
                appModule,
                coinMonitoringViewModels,
                coinDetailedViewModels
            )
        }
    }
}