package com.codingurkan.ag_store.ui.fragments.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingurkan.ag_store.databinding.FragmentGalleryDetailsBinding
import com.codingurkan.ag_store.adapter.DashboardAdapter
import com.codingurkan.ag_store.util.PageLists

class GalleryDetailsFragment : Fragment() {


    private var binding : FragmentGalleryDetailsBinding? = null

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


}