package com.example.firstapiproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapiproject.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PlayerViewModel by viewModels()
    private lateinit var playerAdapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        viewModel.fetchPlayers()
        observePlayers()
    }

    private fun setupRecyclerView() {
        playerAdapter = RecyclerAdapter { int ->
            val action = StartFragmentDirections.actionStartFragmentToPlayerProfile(int)
            findNavController().navigate(action)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = playerAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observePlayers() {
        viewModel.players.observe(viewLifecycleOwner) { playerList ->
            playerAdapter.players=playerList
            val playersWithImages = playerList.mapIndexed { index, player ->
                player.copy(imageUrl = "https://cdn2.thecatapi.com/images/${player.id}.jpg")
            }
            playerAdapter.players = playersWithImages
            playerAdapter.notifyDataSetChanged()

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}