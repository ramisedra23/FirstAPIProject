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
        super.onViewCreated(view, savedInstanceState)

        val firstName = args.firstName
        val lastName = args.lastName

        binding.editTextFirstName.text
        binding.editTextLastName.text

        Log.d("Navigation", "PlayerProfileFragment showing data for $firstName $lastName")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}