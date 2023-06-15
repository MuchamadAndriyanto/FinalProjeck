package com.finalproject.tiketku.network

import com.finalproject.tiketku.model.BandaraAwal
import com.finalproject.tiketku.model.DataLoginUserItem
import com.finalproject.tiketku.model.DataPassword
import com.finalproject.tiketku.model.DataPostUsersItem
import com.finalproject.tiketku.model.DataResetPassword
import com.finalproject.tiketku.model.ResponseLogin
import com.finalproject.tiketku.model.ResponseResetPassword
import com.finalproject.tiketku.model.ResponseUsersItem
import com.finalproject.tiketku.model.SearchRespomse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getAllUsers(): Call<List<ResponseUsersItem>>

    @POST("login")
    fun postLogin(@Body request: DataLoginUserItem ): Call<ResponseLogin>

    @POST("register")
    fun registerUser(@Body request: ResponseUsersItem): Call<List<DataPostUsersItem>>

    @POST("forgotPassword")
    fun postPassword(@Body request: DataPassword) : Call<DataPassword>

    @POST("reset-password")
    fun postResetPassword(@Body request: DataResetPassword) : Call<ResponseResetPassword>

    @GET("city")
    fun getSearch(
        @Query("kota") title : String
    ):Call<SearchRespomse>

}