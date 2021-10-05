package com.example.eatoes

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {
    fun getRetroClientInstance(): Retrofit {
        val gson= GsonBuilder().setLenient().create()
        return Retrofit.Builder()
                .baseUrl("https://reqres.in/api/login/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}