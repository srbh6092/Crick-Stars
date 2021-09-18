package com.saurabh.crickstars.ui.sortByName

import android.app.DownloadManager
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.saurabh.crickstars.MainActivity
import com.saurabh.crickstars.MySingleton
import com.saurabh.crickstars.R
import com.saurabh.crickstars.databinding.FragmentSortByNameBinding
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.util.Calendar.getInstance

class SortByNameFragment : Fragment() {

    private lateinit var dashboardViewModel: SortByNameViewModel
    private var _binding: FragmentSortByNameBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(SortByNameViewModel::class.java)

        _binding = FragmentSortByNameBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setHasOptionsMenu(true)

        return root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.sort_invert_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}