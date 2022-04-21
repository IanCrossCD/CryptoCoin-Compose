package com.crossdevelop.cryptocoincompose.common.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.coroutineScope
import java.util.concurrent.Executors


@Database(entities = [FavoriteCoinEntity::class], version = 1)
abstract class CryptoCoinDb : RoomDatabase() {

    abstract fun FavoriteCoinDao(): FavoriteCoinDao

    companion object {

        private var INSTANCE: CryptoCoinDb? = null

        fun getInstance(context: Context): CryptoCoinDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {

                    val rdc: Callback = object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            Executors.newSingleThreadScheduledExecutor().execute {
                                // Prefill DB for testing purpose, and to find heavier data easier
                                val coinDao = (db as CryptoCoinDb).FavoriteCoinDao()
                                coinDao.insertFavoriteCoin(FavoriteCoinEntity(coinId = "bitcoin"))
                                coinDao.insertFavoriteCoin(FavoriteCoinEntity(coinId = "dogecoin"))
                                coinDao.insertFavoriteCoin(FavoriteCoinEntity(coinId = "ethereum"))
                            }
                        }
                    }

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CryptoCoinDb::class.java,
                        "crypto_coin_database"
                    )
                        .addCallback(rdc)
                        .build()

                    instance.query("select 1", null)

                    INSTANCE = instance
                }


                return instance
            }
        }
    }
}