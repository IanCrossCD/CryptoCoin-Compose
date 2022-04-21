package com.crossdevelop.cryptocoincompose.common.di

import android.content.Context
import android.content.SharedPreferences
import com.crossdevelop.cryptocoincompose.BuildConfig
import com.crossdevelop.cryptocoincompose.common.database.CryptoCoinDb
import com.crossdevelop.cryptocoincompose.common.database.FavoriteCoinDao
import com.crossdevelop.cryptocoincompose.common.network.CoreNetworkModule
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Module(includes = [CoreNetworkModule::class])
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("${BuildConfig.APPLICATION_ID}.shared_preferences", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .build()

    @Provides
    fun provideFavoriteCoinDao(@ApplicationContext context: Context): FavoriteCoinDao = CryptoCoinDb.getInstance(context).FavoriteCoinDao()

    @ActivitySnack
    @Provides
    @Singleton
    fun provideActivityViewState(): MutableStateFlow<String?> = MutableStateFlow(null)

}
