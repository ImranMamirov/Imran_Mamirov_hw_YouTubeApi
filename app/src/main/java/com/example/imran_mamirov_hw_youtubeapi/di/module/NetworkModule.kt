package com.example.imran_mamirov_hw_youtubeapi.di.module

import com.example.imran_mamirov_hw_youtubeapi.Utils.Constants.BASE_URL
import com.example.imran_mamirov_hw_youtubeapi.Utils.Constants.TIMEOUT_DURATION
import com.example.imran_mamirov_hw_youtubeapi.data.network.api.YouTubeApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        provideRetrofit(get())
    }
    single {
        provideApiService(get())
    }

    single {
        provideOkHttpClient(get())
    }

    single {
        provideLoggingInterceptor()
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


fun provideApiService(retrofit: Retrofit): YouTubeApiService =
    retrofit.create(YouTubeApiService::class.java)

fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder()
        .readTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        .connectTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()

fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }