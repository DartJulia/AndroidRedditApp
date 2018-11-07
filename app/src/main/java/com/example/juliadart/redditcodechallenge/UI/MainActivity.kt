package com.example.juliadart.redditcodechallenge.UI

import android.arch.lifecycle.MutableLiveData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.example.juliadart.redditcodechallenge.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val searchInput = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayMainFragment()

        searchListener()

    }
    fun searchListener() {
        searchBar.setOnKeyListener { view, i, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                if (!searchBar.toString().isNullOrEmpty()) {
                    searchInput.value = searchBar.toString()
                    displaySubredditFragment()
                }
                true
            } else false
        }
    }

    private fun displayMainFragment(cleanStack: Boolean = false) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, MainFragment.newInstance())
            .commit()
    }

    private fun displayViewPostFragment(url: String, cleanStack: Boolean = false) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, ViewPostFragment())
            .commit()
    }
    private fun displaySubredditFragment() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, SubredditFragment())
            .commit()
    }


}





