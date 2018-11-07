package com.example.juliadart.redditcodechallenge.UI

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.juliadart.redditcodechallenge.R
import com.example.juliadart.redditcodechallenge.RedditViewModel
import com.example.juliadart.redditcodechallenge.inflate

class SubredditFragment() : Fragment() {

    lateinit var viewModel: RedditViewModel

    companion object {

        @JvmStatic
        fun newInstance(): SubredditFragment {
            val fragment = SubredditFragment()

            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RedditViewModel::class.java)
        viewModel.redditResponse
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.fragment_main)

        return view
    }

}