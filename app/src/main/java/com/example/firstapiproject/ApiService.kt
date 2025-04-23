package com.example.firstapiproject

import com.example.firstapiproject.data.PlayerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Authorization: f2c88c68-0c89-4aab-be4d-420fdba05a21")
    @GET("players")
    suspend fun getPlayers(): Response<PlayerResponse>
}