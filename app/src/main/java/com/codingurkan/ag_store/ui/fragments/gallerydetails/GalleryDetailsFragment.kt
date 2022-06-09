package com.codingurkan.ag_store.ui.fragments.gallerydetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.codingurkan.ag_store.databinding.FragmentGalleryDetailsBinding
import com.codingurkan.ag_store.adapter.DashboardAdapter
import com.codingurkan.ag_store.model.DataItem
import com.codingurkan.ag_store.util.PageLists

class GalleryDetailsFragment : Fragment() {


    private var binding : FragmentGalleryDetailsBinding? = null
   // private var galleryDetailsAdapter : GalleryDetailsAdapter? = null
    private val galleryDetailsViewModel : GalleryDetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentGalleryDetailsBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt(POSITION_ARG)
        val viewPager = binding?.galleryVp

        position?.let {
            when(position){
                0 -> viewPager?.adapter = DashboardAdapter(PageLists.clothes)
                1 -> viewPager?.adapter = DashboardAdapter(PageLists.foods)
            }
        }

    }


    companion object{
        var POSITION_ARG = "position_arg"
        @JvmStatic

        fun newInstance(position: Int) = GalleryDetailsFragment().apply {
            arguments = Bundle().apply {
                putInt(POSITION_ARG,position)
            }
        }
    }

    /*
    private fun setupAdapter(){
        galleryDetailsViewModel.galleryDetailsList.observe(viewLifecycleOwner, Observer {
            galleryDetailsAdapter = GalleryDetailsAdapter(it,object: GalleryDetailsAdapter.ItemClickListener{
                override fun onClick(dataItem: DataItem) {
                    galleryDetailsViewModel.addBasket(dataItem)
                }

            })

        })
    }

     */

}