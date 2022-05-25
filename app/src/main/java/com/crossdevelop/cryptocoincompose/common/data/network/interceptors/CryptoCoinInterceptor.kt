package com.crossdevelop.cryptocoincompose.common.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class CryptoCoinInterceptor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
//            .addHeader("accept", "application/json")
            .build()

        return chain.proceed(request)

    }
}