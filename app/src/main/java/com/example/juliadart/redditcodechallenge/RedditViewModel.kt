package com.example.juliadart.redditcodechallenge

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.juliadart.redditcodechallenge.API.ApiClient
import com.example.juliadart.redditcodechallenge.Model.RedditResponse
import io.reactivex.schedulers.Schedulers

class RedditViewModel : ViewModel() {

    private var apiClient: ApiClient =
        ApiClient()
    val redditResponse = MutableLiveData<RedditResponse>()

    init {
        getApiData()
    }

    @SuppressLint("CheckResult")
    fun getApiData() {
        apiClient.getMainPage().subscribeOn(Schedulers.io()).subscribe({ response ->
            Log.d("JD", response.toString())
            redditResponse.postValue(response)

        }, { throwable ->
            Log.e("JD", throwable.message)
        })

    }

    @SuppressLint("CheckResult")
    fun getSubReddit(query: String) {
        apiClient.getSubReddit(query).subscribeOn(Schedulers.io()).subscribe { response ->
            redditResponse.postValue(response)
        }
    }
}
