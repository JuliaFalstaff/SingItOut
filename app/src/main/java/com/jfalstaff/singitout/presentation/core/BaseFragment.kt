package com.jfalstaff.singitout.presentation.core

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding>(
    private val bindingInflater: (LayoutInflater) -> T
) : Fragment() {

    private var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Rirang","onCreate" )
    }

    override fun onStart() {
        super.onStart()
        Log.d("Rirang","onStart" )
    }

    override fun onResume() {
        super.onResume()
        Log.d("Rirang","onResume" )
    }

    override fun onPause() {
            super.onPause()
        Log.d("Rirang","onPause" )
    }

    override fun onStop() {
        super.onStop()
        Log.d("Rirang","onStop" )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Rirang","onDestroyView" )
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Rirang","onDestroy" )
    }
}