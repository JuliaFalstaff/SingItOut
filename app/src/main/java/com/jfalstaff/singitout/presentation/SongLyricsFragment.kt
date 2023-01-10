package com.jfalstaff.singitout.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jfalstaff.singitout.databinding.FragmentLyricBinding

class SongLyricsFragment : Fragment() {

    private var _binding: FragmentLyricBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[SongLyricsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLyricBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val songId = arguments?.getInt(ID_SONG) ?: 0
        initViewModel(songId)
    }

    private fun initViewModel(id: Int) {
        viewModel.loadSongLyrics(id)
        viewModel.lyrics.observe(viewLifecycleOwner) {
            binding.lyricTextView.text = it.lyrics?.body?.plain ?: "no data lyrics. Empty?"
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        private const val ID_SONG = "id_song"
        fun newInstance(id: Int)= SongLyricsFragment().apply {
            arguments = Bundle().apply {
                putInt(ID_SONG, id)
            }
        }
    }
}