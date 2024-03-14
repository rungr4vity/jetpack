package com.example.jetpack.protocols

import com.example.jetpack.models.Items
import retrofit2.Call
import retrofit2.http.GET

interface retrofitService {
    @GET("posts")
    fun getInfo(): Call<List<Items>>


}