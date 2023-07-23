package com.dkgtech.dmovie.api

import com.dkgtech.dmovie.model.WhatStreamIndiaModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiHelper {

    @GET("getWhatsStreaming")
    fun getWhatsStreamIndia(
        @Header("X-RapidAPI-Key") auth: String,
        @Header("X-RapidAPI-Host") auth1: String,
        @Query("country") country: String
    ): Call<WhatStreamIndiaModel>


    companion object {
        val BASE_URL = "https://imdb188.p.rapidapi.com/api/v1/"

        fun create(): ApiHelper {

            val retrofitClient = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofitClient.create(ApiHelper::class.java)
        }

    }

}