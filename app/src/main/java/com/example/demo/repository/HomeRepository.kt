package com.example.demo.repository

import com.example.demo.api.RetrofitClient
import com.example.demo.models.ListProductResponse
import retrofit2.Response

class HomeRepository {

    suspend fun getListProduct() : Response<ListProductResponse> {
        return RetrofitClient.getDummyApi.getListProduct()
    }
}