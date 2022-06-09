package com.codingurkan.ag_store.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingurkan.ag_store.databinding.GalleryDetailsItemsRowBinding
import com.codingurkan.ag_store.model.DataItem

class GalleryDetailsAdapter(val list : ArrayList<DataItem>,
                            val itemClickListener : ItemClickListener ) : RecyclerView.Adapter<GalleryDetailsAdapter.GDVH>(){

    class GDVH(val binding: GalleryDetailsItemsRowBinding) : RecyclerView.ViewHolder(binding.root)



    interface ItemClickListener{
        fun onClick(dataItem: DataItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GDVH {
        val view = GalleryDetailsItemsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GDVH(view)
    }

    override fun onBindViewHolder(holder: GDVH, position: Int) {
        TODO("Not yet implemented")
    }
}