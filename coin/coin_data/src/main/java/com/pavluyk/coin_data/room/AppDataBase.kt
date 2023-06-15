package com.pavluyk.coin_data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pavluyk.coin_data.room.dao.CoinDao
import com.pavluyk.coin_data.room.models.CoinModelRoom

@Database(
    entities = [
        CoinModelRoom::class
    ],
    version = 3, exportSchema = false
)

abstract class AppDataBase : RoomDatabase() {

    abstract val coinDao: CoinDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                return instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "coin_app_db"
                )
                    .fallbackToDestructiveMigration()
                    .build().also {
                        instance = it
                    }
            }
        }
    }
}