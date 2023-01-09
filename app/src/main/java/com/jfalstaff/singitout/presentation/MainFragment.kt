package com.jfalstaff.singitout.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.map
import com.jfalstaff.singitout.R
import com.jfalstaff.singitout.databinding.FragmentMainBinding
import com.jfalstaff.singitout.presentation.adapters.SearchAdapter
import com.jfalstaff.singitout.presentation.adapters.SearchArtistAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var searchExpression = ""
    private lateinit var adapter: SearchAdapter
    private lateinit var adapterArtist: SearchArtistAdapter
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        initSearchToolbar()
        addAdaptersStateListeners()
    }

    private fun initSearchToolbar() {
        binding.toolbarLayout.searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchExpression = query?.trim().toString()
                getPagingSearchData(searchExpression)
                Log.d("VVV Submit", searchExpression)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun addAdaptersStateListeners() {
        adapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.Loading -> {
                    binding.progressBarSearch.visibility = View.VISIBLE
                    binding.artistHeaderTextView.visibility = View.INVISIBLE
                    binding.lyricsHeaderTextView.visibility = View.INVISIBLE
                }
                is LoadState.NotLoading -> {
                    binding.progressBarSearch.visibility = View.INVISIBLE
                    binding.artistHeaderTextView.visibility = View.VISIBLE
                    binding.lyricsHeaderTextView.visibility = View.VISIBLE
                }
                is LoadState.Error -> {
                    binding.progressBarSearch.visibility = View.INVISIBLE
                    binding.artistHeaderTextView.visibility = View.INVISIBLE
                    binding.lyricsHeaderTextView.visibility = View.INVISIBLE
                    Toast.makeText(
                        requireContext(),
                        "Error: ${(it.refresh as LoadState.Error).error.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun getPagingSearchData(searchExpression: String) {
        this.lifecycleScope.launch {
            viewModel.getPagingData(searchExpression).collectLatest {
                adapter.submitData(it)
                Log.d("VVV Paging", "$it")
            }
        }
        this.lifecycleScope.launch {
            viewModel.getPagingDataOfArtist(searchExpression).collectLatest {
                adapterArtist.submitData(it.map { it.result.primaryArtist })
            }
        }
    }

    private fun initAdapters() {
        adapter = SearchAdapter()
        binding.recyclerSearch.adapter = adapter
        adapterArtist = SearchArtistAdapter()
        binding.horizontalRV.adapter = adapterArtist
        adapterArtist.onItemArtistClickListener = {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, ArtistInfoFragment.newInstance(it?.id ?: 0))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}