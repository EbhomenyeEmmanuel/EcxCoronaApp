package com.esq.ecxcoronaapp.data

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.esq.ecxcoronaapp.R
import com.esq.ecxcoronaapp.databinding.ContentNewsRecyclerListItemBinding
import com.esq.ecxcoronaapp.domain.model.NewsListModel

class NewsFragmentAdapter(private val context: Context, private val homeListInfo: List<NewsListModel>) :
    RecyclerView.Adapter<NewsFragmentAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = DataBindingUtil.inflate<ContentNewsRecyclerListItemBinding>(LayoutInflater.from(context), R.layout.content_news_recycler_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return homeListInfo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val homeInfo = homeListInfo[position]
        holder.setData(homeInfo)
    }

    inner class MyViewHolder(private val binding: ContentNewsRecyclerListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(newsListModel: NewsListModel?) {
            newsListModel?.let {
                with(newsListModel){
                    binding.imageViewForCard.setImageResource(image)
                    binding.title.text = news
                }
            }
        }
    }

}