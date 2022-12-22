package com.jfalstaff.singitout.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.paging.map
import com.jfalstaff.singitout.databinding.ActivityMainBinding
import com.jfalstaff.singitout.presentation.adapters.SearchAdapter
import com.jfalstaff.singitout.presentation.adapters.SearchArtistAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: SearchAdapter
    private lateinit var adapterArtist: SearchArtistAdapter
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapters()
        getPagingSearchData()
        addAdaptersStateListeners()
    }

    private fun addAdaptersStateListeners() {
        adapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.Loading -> {
                    binding.progressBarSearch.visibility = View.VISIBLE
                    binding.ArtistHeaderTextView.visibility = View.INVISIBLE
                    binding.LyricsHeaderTextView.visibility = View.INVISIBLE
                }
                is LoadState.NotLoading -> {
                    binding.progressBarSearch.visibility = View.INVISIBLE
                    binding.ArtistHeaderTextView.visibility = View.VISIBLE
                    binding.LyricsHeaderTextView.visibility = View.VISIBLE
                }
                is LoadState.Error -> {
                    binding.progressBarSearch.visibility = View.INVISIBLE
                    binding.ArtistHeaderTextView.visibility = View.INVISIBLE
                    binding.LyricsHeaderTextView.visibility = View.INVISIBLE
                    Toast.makeText(
                        this,
                        "Error: ${(it.refresh as LoadState.Error).error.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun getPagingSearchData() {
        this.lifecycleScope.launch {
            viewModel.getPagingData("cocorosie").collectLatest {
                adapter.submitData(it)
            }
        }
        this.lifecycleScope.launch {
            viewModel.getPagingDataOfArtist("cocorosie").collectLatest {
                adapterArtist.submitData(it.map { it.result.primaryArtist })
            }
        }
    }

    private fun initAdapters() {
        adapter = SearchAdapter()
        binding.recyclerSearch.adapter = adapter
        adapterArtist = SearchArtistAdapter()
        binding.horizontalRV.adapter = adapterArtist
    }


//        adapter.addLoadStateListener {
//            if (it.refresh == LoadState.Loading) {
//                //show progress
//            } else {
//                //hide progress
//            }
//        }
}
