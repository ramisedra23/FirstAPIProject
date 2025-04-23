package com.example.firstapiproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapiproject.Player
import com.example.firstapiproject.PlayerRepository
import com.example.firstapiproject.RetrofitInstance
import kotlinx.coroutines.launch

class PlayerViewModel : ViewModel() {
    private val repository = PlayerRepository(RetrofitInstance.api)

    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> get() = _players

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun fetchPlayers() {
        viewModelScope.launch {
            try {
                val response = repository.getPlayers()
                if (response.isSuccessful) {
                    _players.value = response.body()?.data ?: emptyList()
                    Log.d("API_RESPONSE", "Players: ${_players.value?.size}")
                } else {
                    _error.value = "Error ${response.code()}: ${response.message()}"
                    Log.e("API_ERROR", "Error ${response.code()}: ${response.message()}")
                }
            } catch (e: Exception) {
                _error.value = e.message
                Log.e("API_EXCEPTION", "Exception: ${e.message}")
            }
        }
    }
}