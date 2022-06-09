package com.codingurkan.ag_store.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingurkan.ag_store.databinding.GalleryDetailsItemsRowBinding
import com.codingurkan.ag_store.model.DataItem

class DashboardAdapter(private val dataItemList : ArrayList<DataItem>) : RecyclerView.Adapter<DashboardAdapter.DashboardVH>() {

   inner class DashboardVH(private val binding : GalleryDetailsItemsRowBinding) : RecyclerView.ViewHolder(binding.root){
       fun bindItem(dataItem: DataItem){
           binding.apply {
               titleTv.text =dataItem.title
               descTv.text = dataItem.desc
               dataItem.photo?.let {
                   iconTv.setImageResource(it) //let - kontrol et
               }
             //  iconTv.setImageResource(dataItem.photo)
               priceTv.text = dataItem.price
           }
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardVH {
        val view = GalleryDetailsItemsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false )
        return DashboardVH(view)
    }

    override fun onBindViewHolder(holder: DashboardVH, position: Int) {
        holder.bindItem(dataItemList[position])
    }

    override fun getItemCount(): Int {
        return dataItemList.size
    }
}