package com.jfalstaff.singitout.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.jfalstaff.singitout.R
import com.jfalstaff.singitout.data.network.ApiFactory
import com.jfalstaff.singitout.databinding.ActivityMainBinding
import com.jfalstaff.singitout.presentation.adapters.SearchAdapter
import com.jfalstaff.singitout.presentation.adapters.SearchArtistAdapter
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

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
        viemodel.loadSearchResult("yves")
        viemodel.searchResult.observe(this) {
            adapter.submitList(it.response.hits)
            adapterArtist.submitList(it.response.hits?.distinctBy { it.result.primaryArtist })
        }
    }
}