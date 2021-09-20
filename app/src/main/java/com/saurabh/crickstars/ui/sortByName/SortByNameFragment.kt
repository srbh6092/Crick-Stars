package com.saurabh.crickstars.ui.sortByName

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurabh.crickstars.*
import com.saurabh.crickstars.databinding.FragmentSortByNameBinding
import kotlinx.coroutines.InternalCoroutinesApi
import com.saurabh.crickstars.PlayerAdapter as PlayerAdapter

class SortByNameFragment : Fragment() {

    @InternalCoroutinesApi
    private lateinit var viewModel: PlayerViewModel
    private var _binding: FragmentSortByNameBinding? = null
    private var lastNameSort: Boolean =false
    private lateinit var adapter:PlayerAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //stating that item is sorted by first name
        lastNameSort=false

        _binding = FragmentSortByNameBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setHasOptionsMenu(true)



        //setting viewModel
        viewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)

        //setting recyclerView
        binding.rvPlayerList.layoutManager= LinearLayoutManager(context)

        //setting adapter
        adapter = PlayerAdapter(this.requireActivity())

        //getting data in adapter
        viewModel.allPlayerFNameAsc.observe(viewLifecycleOwner, Observer {list ->
            list?.let {
                adapter.updateList(it)}
        })

        //connecting adapter to recyclerView
        binding.rvPlayerList.adapter=adapter

        return root
    }


    @InternalCoroutinesApi
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.sort_invert_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @InternalCoroutinesApi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

            //when Top-Right sort button is clicked
        when(item.itemId){
            R.id.invert_sort->{

                //if item is sorted by last name, sort by first name
                if(lastNameSort){
                    viewModel.allPlayerFNameAsc.observe(viewLifecycleOwner, Observer {list ->
                        list?.let {
                            adapter.updateList(it)}
                    })
                    //stating that item is sorted by first name
                    lastNameSort=false
                    Toast.makeText(context,"Sorting by First Name",Toast.LENGTH_LONG).show()
                }
                //if item is sorted by first name, sort by last name
                else{
                    viewModel.allPlayerLNameAsc.observe(viewLifecycleOwner, Observer {list ->
                        list?.let {
                            adapter.updateList(it)}
                    })
                    //stating that item is sorted by last name
                    lastNameSort=true
                    Toast.makeText(context,"Sorting by Last name",Toast.LENGTH_LONG).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}