package com.pavluyk.coin_domain.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatcherProvider {

    fun main(): CoroutineDispatcher = Dispatchers.Main

    fun io(): CoroutineDispatcher = Dispatchers.IO
}

object DefaultDispatcherProvider : DispatcherProvider
