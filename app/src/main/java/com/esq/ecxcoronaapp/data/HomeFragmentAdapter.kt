package com.esq.ecxcoronaapp.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esq.ecxcoronaapp.R
import com.esq.ecxcoronaapp.domain.model.HomeListModel
import kotlinx.android.synthetic.main.content_home_recycler_list_item.view.*

class HomeFragmentAdapter(val context: Context, private val homeListInfo: List<HomeListModel>) :
    RecyclerView.Adapter<HomeFragmentAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.content_home_recycler_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return homeListInfo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val homeInfo = homeListInfo[position]
        holder.setData(homeInfo)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(homeListModel: HomeListModel?) {
            homeListModel?.let {
                itemView.imageViewForCard.setImageResource(homeListModel.image)
                itemView.title.text = homeListModel.title.toString()
                itemView.subtitle.text = homeListModel.subTitle.toString()
            }
        }
    }

}