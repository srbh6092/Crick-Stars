package com.saurabh.crickstars.ui.sortByCountry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.saurabh.crickstars.databinding.FragmentSortByCountryBinding

class SortByCountryFragment : Fragment() {

    private lateinit var homeViewModel: SortByCountryViewModel
    private var _binding: FragmentSortByCountryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(SortByCountryViewModel::class.java)

        _binding = FragmentSortByCountryBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}