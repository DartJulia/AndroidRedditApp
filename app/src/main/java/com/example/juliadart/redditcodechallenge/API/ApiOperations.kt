package com.example.juliadart.redditcodechallenge.API

import com.example.juliadart.redditcodechallenge.Model.RedditResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiOperations {

    // Request method and URL specified in the annotation

    @GET("r/{subreddit}.json")
    fun getSubReddits(@Query("subreddit") subreddit: String): Single<RedditResponse>

    @GET(".json?limit=100")
    fun getMain(): Single<RedditResponse>

    @GET("/top.json")
    fun getTop(): Single<RedditResponse>

    //@Query("after") after: String,
    //               @Query("limit") limit: String
}