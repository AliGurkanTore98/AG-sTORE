package com.codingurkan.ag_store.ui.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.codingurkan.ag_store.adapter.DashboardAdapter
import com.codingurkan.ag_store.databinding.FragmentDashboardBinding
import com.codingurkan.ag_store.util.PageLists

class DashboardFragment : Fragment() {

    private var binding : FragmentDashboardBinding? = null
    private var viewPager2 : ViewPager2? = null
    private val pager2Callback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            if (position == PageLists.introSlides.size -1){
                binding?.controllerButton?.text = "Finish"
                binding?.controllerButton?.setOnClickListener {
                    val action = DashboardFragmentDirections.actionDashboardFragmentToGalleryFragment()
                    findNavController().navigate(action)

                }
            }else{
                binding?.controllerButton?.text = "Next"
                binding?.controllerButton?.setOnClickListener {
                    viewPager2?.currentItem = position + 1
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager(binding!!)
    }
    private fun setupViewPager(binding: FragmentDashboardBinding){
        val adapter = DashboardAdapter(PageLists.introSlides)
        viewPager2 = binding.viewPager
        viewPager2?.adapter = adapter
        viewPager2?.registerOnPageChangeCallback(pager2Callback)

        binding.dotsIndicator.setViewPager2(viewPager2!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewPager2?.unregisterOnPageChangeCallback(pager2Callback)
    }



}