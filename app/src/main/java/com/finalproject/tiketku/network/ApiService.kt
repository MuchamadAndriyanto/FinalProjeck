package com.finalproject.tiketku.network

import com.finalproject.tiketku.model.DataPostUsersItem
import com.finalproject.tiketku.model.ResponseUsersItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("users")
    fun getAllUsers(): Call<List<ResponseUsersItem>>

    @POST("login")
    fun getLogin(): Call<List<DataPostUsersItem>>

    @POST("register")
    fun registerUser(@Body request: ResponseUsersItem): Call<List<DataPostUsersItem>>

}