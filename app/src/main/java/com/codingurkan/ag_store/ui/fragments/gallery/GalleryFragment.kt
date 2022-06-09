package com.codingurkan.ag_store.ui.fragments.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingurkan.ag_store.adapter.GalleryAdapter
import com.codingurkan.ag_store.databinding.FragmentGalleryBinding
import com.google.android.material.tabs.TabLayoutMediator

class GalleryFragment : Fragment() {

    private var binding : FragmentGalleryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter(){
        val galleryViewPager = binding?.galleryVp
        val adapter = GalleryAdapter(this@GalleryFragment)
        galleryViewPager?.adapter = adapter

        TabLayoutMediator(binding!!.tabLayout,galleryViewPager!!){
                tab,position ->
            tab.text = getTitle(position)
        }.attach()
    }
    private fun getTitle(position: Int) : String?{
        return when(position){
            0 -> "Clothes"
            1 ->"Foods"
            else ->null
        }
    }




}