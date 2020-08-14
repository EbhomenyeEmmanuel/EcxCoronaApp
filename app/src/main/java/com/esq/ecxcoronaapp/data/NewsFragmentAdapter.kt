package com.esq.ecxcoronaapp.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esq.ecxcoronaapp.R
import com.esq.ecxcoronaapp.domain.model.NewsListModel
import kotlinx.android.synthetic.main.content_news_recycler_list_item.view.*

class NewsFragmentAdapter(
    private val context: Context,
    private val homeListInfo: List<NewsListModel>
) :
    RecyclerView.Adapter<NewsFragmentAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(context).inflate(
                R.layout.content_news_recycler_list_item,
                parent,
                false
            )
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return homeListInfo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val homeInfo = homeListInfo[position]
        holder.setData(homeInfo)
    }

    inner class MyViewHolder(private val item: View) :
        RecyclerView.ViewHolder(item) {
        fun setData(newsListModel: NewsListModel) {
            with(newsListModel) {
                item.imageViewForCard.setImageDrawable(context.getDrawable(image))
                item.title.text = context.getString(news)
            }
        }
    }

}