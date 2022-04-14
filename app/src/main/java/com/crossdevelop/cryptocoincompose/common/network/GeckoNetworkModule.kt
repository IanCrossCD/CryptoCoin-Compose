package com.crossdevelop.cryptocoincompose.common.network

import com.crossdevelop.cryptocoincompose.BuildConfig
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GeckoNetworkModule {

    @Provides
    @Singleton
    fun provideGeckoApiService(
        client: OkHttpClient,
        moshi: Moshi
    ): GeckoApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(GeckoApiService::class.java)
    }
}
