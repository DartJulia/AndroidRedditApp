package com.example.juliadart.redditcodechallenge.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.juliadart.redditcodechallenge.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayMainFragment()

    }

    private fun displayMainFragment() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, MainFragment.newInstance())
            .commit()
    }
// TODO: Open post comments in a webview
    private fun displayViewPostFragment(url: String) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, ViewPostFragment())
            .commit()
    }

    // TODO: for subreddit searching functionality
    private fun displaySubredditFragment() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, SubredditFragment())
            .commit()
    }


}





