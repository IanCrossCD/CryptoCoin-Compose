package com.crossdevelop.cryptocoincompose.common.di

import android.content.Context
import android.content.SharedPreferences
import com.crossdevelop.cryptocoincompose.BuildConfig
import com.crossdevelop.cryptocoincompose.common.network.CoreNetworkModule
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [CoreNetworkModule::class])
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("${BuildConfig.APPLICATION_ID}.shared_preferences", Context.MODE_PRIVATE)
        // TODO research why this is causing issues
//        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
//        val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
//        return EncryptedSharedPreferences.create(
//            "${BuildConfig.APPLICATION_ID}.shared_preferences",
//            masterKeyAlias,
//            context,
//            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
//            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
//        )
    }

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .build()

}
