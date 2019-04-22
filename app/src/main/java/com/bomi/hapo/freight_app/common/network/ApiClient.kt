package com.bomi.hapo.freight_app.common.network

import android.content.Context
import com.bomi.hapo.freight_app.common.App
import com.bomi.hapo.freight_app.common.BASE_URL
import com.bomi.hapo.freight_app.common.REQUEST_TIMEOUT
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * Created by JWHAPO
 * -19. 4. 7 오후 5:08
 */

object ApiClient {
    private lateinit var retrofit: Retrofit
    private lateinit var okHttpClient: OkHttpClient

    fun getClient(context: Context) : Retrofit{
        initOkHttp(context)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        return retrofit
    }

    private fun  initOkHttp(context: Context){
        var httpClient :OkHttpClient.Builder =
            OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)

        httpClient.addInterceptor(Interceptor { chain ->
            var request = chain
                .request()
                .newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer ${App.prefs.apiToken}")
                .build()
            chain.proceed(request)
        })

        var interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient = httpClient.build()
    }

}