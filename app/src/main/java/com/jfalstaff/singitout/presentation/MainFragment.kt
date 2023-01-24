package com.jfalstaff.singitout.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.map
import com.github.terrakok.cicerone.Router
import com.jfalstaff.singitout.databinding.FragmentMainBinding
import com.jfalstaff.singitout.presentation.adapters.SearchAdapter
import com.jfalstaff.singitout.presentation.adapters.SearchArtistAdapter
import com.jfalstaff.singitout.presentation.core.BaseFragment
import com.jfalstaff.singitout.presentation.navigation.IScreens
import com.jfalstaff.singitout.presentation.viewmodels.MainViewModel
import com.jfalstaff.singitout.presentation.viewmodels.ViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screen: IScreens

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private var searchExpression = ""
    private lateinit var adapter: SearchAdapter
    private lateinit var adapterArtist: SearchArtistAdapter
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }
    private val component by lazy {
        (requireActivity().application as SingItOutApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        initSearchToolbar()
        addAdaptersStateListeners()
    }

    override fun onResume() {
        super.onResume()
        if (searchExpression.isNotEmpty()) {
            getPagingSearchData(searchExpression)
        }
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
                    binding.artistRVMock.visibility = View.INVISIBLE
                    binding.lyricsRVMock.visibility = View.INVISIBLE
                }
                is LoadState.NotLoading -> {
                    binding.progressBarSearch.visibility = View.INVISIBLE
                    binding.artistHeaderTextView.visibility = View.VISIBLE
                    binding.lyricsHeaderTextView.visibility = View.VISIBLE
                }
                is LoadState.Error -> {
                    binding.progressBarSearch.visibility = View.INVISIBLE
                    binding.artistRVMock.visibility = View.VISIBLE
                    binding.lyricsRVMock.visibility = View.VISIBLE
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
        viewLifecycleOwner.lifecycleScope.launch {
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
        setAdaptersListeners()
    }

    private fun setAdaptersListeners() {
        adapterArtist.onItemArtistClickListener = {
            router.navigateTo(screen.artistInfoScreen(it?.id ?: 0))

        }
        adapter.onItemHitClickListener = {
            router.navigateTo(screen.songLyricsScreen(it?.result?.id ?: 0))
        }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}