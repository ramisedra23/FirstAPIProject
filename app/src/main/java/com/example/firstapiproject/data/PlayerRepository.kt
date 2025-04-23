package com.example.firstapiproject.data

import com.example.firstapiproject.ApiService
import retrofit2.Callback
import retrofit2.Response

class PlayerRepository(private val apiService: ApiService) {
    suspend fun getPlayers(): Response<PlayerResponse> {
        return apiService.getPlayers()
    }
}