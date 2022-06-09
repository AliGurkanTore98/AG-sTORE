package com.codingurkan.ag_store.adapter


import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codingurkan.ag_store.ui.fragments.gallery.GalleryDetailsFragment

class GalleryAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }
    override fun createFragment(position: Int) = GalleryDetailsFragment.newInstance(position)
}