package com.example.firstapiproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.firstapiproject.databinding.FragmentPlayerProfileBinding

class PlayerProfileFragment : Fragment() {
    private var _binding: FragmentPlayerProfileBinding? = null
    private val binding get() = _binding!!

    private val args: PlayerProfileFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("Navigation", "PlayerProfileFragment onCreateView called")
        _binding = FragmentPlayerProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val player = arguments?.let {
            PlayerProfileFragmentArgs.fromBundle(it).player
        }

        player?.let {
            binding.editTextFirstName.setText(it.first_name)
            binding.editTextLastName.setText(it.last_name)
            binding.editTextPosition.setText(it.position)

            binding.editTextHeight.setText(it.height_feet?.toString() ?: "N/A")
            binding.editTextWeight.setText(it.weight_pounds?.toString() ?: "N/A")
            binding.editTextWeightJerseyNumber.setText(it.jersey_number ?: "N/A")
            binding.editTextWeightCollege.setText(it.college ?: "N/A")
            binding.editTextWeightCountry.setText(it.country ?: "N/A")
            binding.editTextWeightDraftYear.setText(it.draft_year?.toString() ?: "N/A")
            binding.editTextWeightDraftRound.setText(it.draft_round?.toString() ?: "N/A")
            binding.editTextWeightDraftNumber.setText(it.draft_number?.toString() ?: "N/A")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}