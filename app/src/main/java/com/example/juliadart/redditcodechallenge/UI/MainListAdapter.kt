package com.example.juliadart.redditcodechallenge.UI

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.support.annotation.NonNull
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.juliadart.redditcodechallenge.Model.Child
import com.example.juliadart.redditcodechallenge.Model.ChildData
import com.example.juliadart.redditcodechallenge.R
import com.example.juliadart.redditcodechallenge.R.id.titleItem
import com.example.juliadart.redditcodechallenge.RedditViewModel
import com.example.juliadart.redditcodechallenge.loadImg
import kotlinx.android.synthetic.main.list_view_main.*

class MainListAdapter() :
    RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    private val childrenArray: ArrayList<ChildData> = ArrayList()

    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_view_main, parent, false) as ViewGroup
        )
    }

    override fun getItemCount(): Int {
        return childrenArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.mTitle.text = childrenArray[position].title
        holder.mTitle.setOnClickListener {  }

        holder.mCategory.text =  "r/" + childrenArray[position].subreddit
        holder.mImage.loadImg(childrenArray[position].thumbnail)

    }

    fun setChildData(childList : Collection<ChildData>){
        childrenArray.clear()
        childrenArray.addAll(childList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView) {
            val mTitle: TextView = itemView.findViewById(R.id.titleItem)
            val mImage: ImageView = itemView.findViewById(R.id.imageItem)
            val mCategory: TextView = itemView.findViewById((R.id.categoryItem))

    }

    fun openUrl(position: Int){
        childrenArray[position].url
    }
    class InfiniteScrollListener(
        val func: () -> Unit,
        val layoutManager: LinearLayoutManager
    )
        : RecyclerView.OnScrollListener() {}

}