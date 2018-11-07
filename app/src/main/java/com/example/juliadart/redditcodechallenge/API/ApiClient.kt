package com.example.juliadart.redditcodechallenge.API

import com.example.juliadart.redditcodechallenge.BuildConfig
import com.example.juliadart.redditcodechallenge.Model.RedditResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit


class ApiClient() {

    private val TAG = ApiClient::class.java.simpleName
    private val retrofit: Retrofit
    private val apiUrl = "https://www.reddit.com/"


    // Moshi converter replaces GSON to process JSON
    // Retrofit API library builder
    private val apiOperations: ApiOperations

    init {

        val client = OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        //links retrofit to api operations (Get methods)
        apiOperations = retrofit.create(ApiOperations::class.java)

    }

    fun getSubReddit(subreddit: String): Single<RedditResponse> {
        return apiOperations.getSubReddits(subreddit)
    }

    fun getMainPage(): Single<RedditResponse> {
        return apiOperations.getMain()
    }

    fun getTop(): Single<RedditResponse> {
        return apiOperations.getTop()
    }
}