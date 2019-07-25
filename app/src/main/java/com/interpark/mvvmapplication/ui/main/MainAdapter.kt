package com.interpark.mvvmapplication.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.interpark.mvvmapplication.R
import com.interpark.mvvmapplication.core.BindingViewHolder
import com.interpark.mvvmapplication.data.db.entity.Address
import com.interpark.mvvmapplication.databinding.ItemMainListBinding

class MainAdapter(val vm: AddressViewModel) : PagedListAdapter<Address, MainAdapter.MainViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main_list, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        getItem(position)?.run {
            holder.binding.item = this
            holder.binding.vm = vm
        }
    }

    class MainViewHolder(view: View) : BindingViewHolder<ItemMainListBinding>(view)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Address>() {
            override fun areItemsTheSame(oldItem: Address, newItem: Address) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Address, newItem: Address) = oldItem == newItem
        }
    }
}
