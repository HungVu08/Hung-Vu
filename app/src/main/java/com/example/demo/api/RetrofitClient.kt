package com.example.demo.api

import com.example.demo.utils.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    companion object{

        var gson = GsonBuilder()
            .setLenient()
            .create()

        val getDummyApi = Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(DummyApi::class.java)
    }
}