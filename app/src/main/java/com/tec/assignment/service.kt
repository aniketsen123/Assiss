package com.tec.assignment

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface service {

    @GET("")
    fun getdetails(@Query("name") queryString: String): Call<List<country>>

    companion object {
        val BASE_URL = "https://api.nationalize.io/"
        fun create(): service {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(service::class.java)
        }
    }
}