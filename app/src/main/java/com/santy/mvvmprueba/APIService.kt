package com.santy.mvvmprueba

import com.santy.mvvmprueba.Model.MailModel
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET
    suspend fun getMessages():Response<MailModel>
}