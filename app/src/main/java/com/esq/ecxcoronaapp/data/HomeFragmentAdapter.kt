package com.esq.ecxcoronaapp.data

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.esq.ecxcoronaapp.R
import com.esq.ecxcoronaapp.databinding.ContentHomeRecyclerListItemBinding
import com.esq.ecxcoronaapp.domain.model.HomeListModel

class HomeFragmentAdapter(val context: Context, private val homeListInfo: List<HomeListModel>) :
    RecyclerView.Adapter<HomeFragmentAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            DataBindingUtil.inflate<ContentHomeRecyclerListItemBinding>(
                LayoutInflater.from(context),
                R.layout.content_home_recycler_list_item,
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

    inner class MyViewHolder constructor(private val binding: ContentHomeRecyclerListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(homeListModel: HomeListModel?) {
            homeListModel?.let {
                binding.imageViewForCard.setImageResource(homeListModel.image)
                binding.title.text = homeListModel.title.toString()
                binding.subtitle.text = homeListModel.subTitle.toString()
            }
        }
    }

}