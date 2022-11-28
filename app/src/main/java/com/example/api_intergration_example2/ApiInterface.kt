package com.example.api_intergration_example2

import com.example.api_intergration_example2.models.ApiData
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.jsonserve.com/"
interface ApiInterface {
    @GET("NFYsXW/")
   suspend fun getData():Response<ApiData>
}

object DataService{

    val Instance : ApiInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        Instance = retrofit.create(ApiInterface::class.java)
    }
}