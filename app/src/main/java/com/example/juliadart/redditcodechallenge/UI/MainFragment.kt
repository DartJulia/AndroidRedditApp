package com.example.juliadart.redditcodechallenge.UI

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.juliadart.redditcodechallenge.R
import com.example.juliadart.redditcodechallenge.RedditViewModel
import com.example.juliadart.redditcodechallenge.inflate
import kotlinx.android.synthetic.main.list_view_main.*
import android.content.Intent
import android.net.Uri
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*


class MainFragment() : Fragment() {

    private var redditList: RecyclerView? = null
    lateinit var viewModel: RedditViewModel
    private var adapter : MainListAdapter = MainListAdapter()

    companion object {

        @JvmStatic
        fun newInstance(): MainFragment {
            val fragment = MainFragment()

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(RedditViewModel::class.java)
        viewModel.redditResponse
        viewModel.redditResponse.observe(this, Observer { response ->
            adapter.setChildData(response?.data?.children?.map { it.data }.orEmpty())
        })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.fragment_main)

        redditList = view?.findViewById(R.id.rvList) as RecyclerView?
        redditList?.adapter = adapter
        redditList?.setHasFixedSize(true)
        redditList?.layoutManager = LinearLayoutManager(this.context)

       return view
    }

}


