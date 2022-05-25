package com.crossdevelop.cryptocoincompose.common.data.network

import android.content.Context
import com.crossdevelop.cryptocoincompose.common.data.network.interceptors.CryptoCoinInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module(includes = [GeckoNetworkModule::class])
@InstallIn(SingletonComponent::class)
class CoreNetworkModule {

    @Provides
    @Singleton
    fun provideInterceptor(): CryptoCoinInterceptor = CryptoCoinInterceptor()


    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpCache(@ApplicationContext context: Context): Cache {
        val directory = File(context.cacheDir, "okhttp")
        return Cache(directory, 1024 * 1024 * 10L) // 10 MB
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache,
        cryptoCoinInterceptor: CryptoCoinInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .readTimeout(20000, TimeUnit.MILLISECONDS)
            .writeTimeout(20000, TimeUnit.MILLISECONDS)
            .cache(cache)
            .addNetworkInterceptor(logging)
            .addInterceptor(cryptoCoinInterceptor)
            .build()
    }
}
