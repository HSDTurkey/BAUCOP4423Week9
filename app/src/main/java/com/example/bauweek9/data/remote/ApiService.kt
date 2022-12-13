package com.example.bauweek9.data.remote

import com.example.bauweek9.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/api/?results=50")
    suspend fun getAllUsers(): Response<UserResponse>
}





