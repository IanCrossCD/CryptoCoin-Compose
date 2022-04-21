package com.crossdevelop.cryptocoincompose.common.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteCoinDao {

    @Query("SELECT * FROM favorite_coins")
    fun getFavoriteCoins() : List<FavoriteCoinEntity>

    @Insert
    fun insertFavoriteCoin(favoriteCoinEntity: FavoriteCoinEntity)

    @Delete
    fun deleteFavoriteCoin(favoriteCoinEntity: FavoriteCoinEntity)
}