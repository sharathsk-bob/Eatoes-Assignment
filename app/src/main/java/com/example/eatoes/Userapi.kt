package com.example.eatoes

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Userapi {
    @POST("login")
    fun login(
        @Body userRequest:UserRequest
    ): Call<UserResponse>
}