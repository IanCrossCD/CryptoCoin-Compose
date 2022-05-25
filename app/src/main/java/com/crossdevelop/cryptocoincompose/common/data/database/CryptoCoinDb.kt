package com.crossdevelop.cryptocoincompose.common.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [FavoriteCoinEntity::class], version = 1)
abstract class CryptoCoinDb : RoomDatabase() {

    abstract fun FavoriteCoinDao(): FavoriteCoinDao

    companion object {

        private var INSTANCE: CryptoCoinDb? = null

        fun getInstance(context: Context): CryptoCoinDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CryptoCoinDb::class.java,
                        "crypto_coin_database"
                    )
                        .build()

                    instance.query("select 1", null)

                    INSTANCE = instance
                }


                return instance
            }
        }
    }
}