package com.codingurkan.ag_store.ui.fragments.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingurkan.ag_store.databinding.DashboardItemsRowBinding
import com.codingurkan.ag_store.model.DataItem

class DashboardAdapter(private val dataItemList : ArrayList<DataItem>) : RecyclerView.Adapter<DashboardAdapter.DashboardVH>() {

   inner class DashboardVH(private val binding : DashboardItemsRowBinding) : RecyclerView.ViewHolder(binding.root){
       fun bindItem(dataItem: DataItem){
           binding.apply {
               titleTv.text =dataItem.title
               descTv.text = dataItem.desc
               iconTv.setImageResource(dataItem.photo)
           }
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardVH {
        val view = DashboardItemsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false )
        return DashboardVH(view)
    }

    override fun onBindViewHolder(holder: DashboardVH, position: Int) {
        holder.bindItem(dataItemList[position])
    }

    override fun getItemCount(): Int {
        return dataItemList.size
    }
}