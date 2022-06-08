package com.codingurkan.ag_store.ui.fragments.gallery


import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class GalleryDetailsAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }
    override fun createFragment(position: Int) = GalleryDetailsFragment.newInstance(position)
}