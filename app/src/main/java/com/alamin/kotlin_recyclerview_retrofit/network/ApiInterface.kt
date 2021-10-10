package com.alamin.kotlin_recyclerview_retrofit.network

import com.alamin.kotlin_recyclerview_retrofit.model.PostItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getData(): Call<List<PostItem>>
}