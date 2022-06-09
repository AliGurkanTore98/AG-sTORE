package com.codingurkan.ag_store.ui.fragments.gallerydetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingurkan.ag_store.model.DataItem

class GalleryDetailsViewModel : ViewModel() {

    val galleryDetailsList = MutableLiveData<ArrayList<DataItem>>()
    val basket = MutableLiveData<ArrayList<DataItem>>()
    val totalBasket = MutableLiveData<Int>()


    fun addBasket(dataItem: DataItem){
        if (basket.value != null){
            val arrayList = ArrayList(basket.value!!)

            if (arrayList.contains(dataItem)){
                val indexOfFirst = arrayList.indexOfFirst { it == dataItem }
                val relatedProduct = arrayList[indexOfFirst]
                relatedProduct.count += 1
                basket.value = arrayList
            }
        }
        else{
            val arrayList = arrayListOf(dataItem)
            dataItem.count +=1
            basket.value = arrayList
        }
        basket.value.let {
            refreshTotalValue(it!!)
        }
    }

    private fun refreshTotalValue(listOfProduct: List<DataItem>){           //Toplam para tutarı
        var total = 0
        listOfProduct.forEach{ product ->
            val price = product.price?.toIntOrNull()
            price?.let {
                val count = product.count
                val revenue = count * it
                total += revenue
            }
        }
        totalBasket.value = total
    }
    fun deleteProductFromBasket(dataItem: DataItem){
        if (basket.value != null){
            val arrayList = ArrayList(basket.value!!)
            arrayList.remove(dataItem)
            basket.value = arrayList
            refreshTotalValue(arrayList)
        }
    }




}