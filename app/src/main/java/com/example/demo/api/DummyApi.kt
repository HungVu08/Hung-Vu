package com.example.demo.api

import com.example.demo.models.ListProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface DummyApi {

    @GET("/products")
   suspend fun getListProduct() : Response<ListProductResponse>

}