package com.codingurkan.ag_store.ui.fragments.basket

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingurkan.ag_store.adapter.BasketAdapter
import com.codingurkan.ag_store.databinding.FragmentBasketBinding
import com.codingurkan.ag_store.ui.fragments.gallerydetails.GalleryDetailsViewModel


class BasketFragment : Fragment() {

    private var binding : FragmentBasketBinding? = null
    private val galleryDetailsViewModel : GalleryDetailsViewModel by activityViewModels()
    private var basketAdapter : BasketAdapter? = null
    private val swipeCallBack = object : ItemTouchHelper.SimpleCallback(0,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition

            if (basketAdapter != null){
                val selectedProduct = basketAdapter!!.basketList[layoutPosition]
                galleryDetailsViewModel.deleteProductFromBasket(selectedProduct)
                basketAdapter!!.notifyDataSetChanged()
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBasketBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.basketRecyclerView?.layoutManager = LinearLayoutManager(activity?.baseContext)

        ItemTouchHelper(swipeCallBack).attachToRecyclerView(binding?.basketRecyclerView)

        galleryDetailsViewModel.basket.observe(viewLifecycleOwner, Observer {observer->
            basketAdapter = BasketAdapter(observer)
            binding?.basketRecyclerView?.adapter = basketAdapter


        })
        galleryDetailsViewModel.totalBasket.observe(viewLifecycleOwner, Observer {
            "Toplam Sepet: ${it}".also { binding?.totalBasketText?.text = it }
        })
    }

}