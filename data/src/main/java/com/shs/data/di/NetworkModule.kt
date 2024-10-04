package com.shs.data.di

import com.google.gson.GsonBuilder
import com.shs.data.BuildConfig
import com.shs.data.network.interceptor.LogInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkClient(
        httpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(httpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()

    @Provides
    @Singleton
    fun provideHttpClient(
        loggingInterceptor: LogInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(60L, TimeUnit.SECONDS)
        .connectTimeout(60L, TimeUnit.SECONDS)
        .writeTimeout(60L, TimeUnit.SECONDS)
        .also {
            it.addInterceptor(loggingInterceptor)
        }.build()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): LogInterceptor = LogInterceptor()

    @Provides
    @Singleton
    fun provideConverterFactory() : GsonConverterFactory = GsonConverterFactory.create(GsonBuilder().create())

}