package com.jfalstaff.singitout.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
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
    private val viemodel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = SearchAdapter()
        binding.recyclerSearch.adapter = adapter
        adapterArtist = SearchArtistAdapter()
        binding.horizontalRV.adapter = adapterArtist
//        viemodel.loadSearchResult("the national")
//        viemodel.searchResult.observe(this) {
//            adapter.submitData(it)
//            adapterArtist.submitList(it.response.hits?.distinctBy { hit ->
//                hit.result.primaryArtist }
//            )
//        }
        this.lifecycleScope.launch {
            viemodel.getPagingData("cocorosie").collectLatest {
                adapter.submitData(it)
            }
        }
        this.lifecycleScope.launch {
            viemodel.getPagingDataOfArtist("cocorosie").collectLatest {
                adapterArtist.submitData(it.map { it.result.primaryArtist })
            }

        }
    }


//        adapter.addLoadStateListener {
//            if (it.refresh == LoadState.Loading) {
//                //show progress
//            } else {
//                //hide progress
//            }
//        }
}
