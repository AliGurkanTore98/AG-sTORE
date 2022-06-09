package com.codingurkan.ag_store.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingurkan.ag_store.databinding.BasketRecyclerRowBinding
import com.codingurkan.ag_store.model.DataItem

class BasketAdapter(val basketList : ArrayList<DataItem>) : RecyclerView.Adapter<BasketAdapter.BasketVH>(){

   inner class BasketVH(val binding : BasketRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
       fun bindItem(dataItem: DataItem){
           binding.apply {
               basketProductNameText.text =dataItem.title
               dataItem.photo?.let {
                   basketImageView.setImageResource(it) //let - kontrol et
               }
               basketPriceText.text = dataItem.price
               basketCountText.text = dataItem.count.toString()
           }
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketVH {
        val view = BasketRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BasketVH(view)
    }

    override fun onBindViewHolder(holder: BasketVH, position: Int) {
        holder.bindItem(basketList[position])
        }


    override fun getItemCount(): Int {
        return basketList.size
    }
}