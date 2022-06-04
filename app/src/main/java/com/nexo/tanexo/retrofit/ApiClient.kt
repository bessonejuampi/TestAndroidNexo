package com.nexo.tanexo.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {
    private var API_SERVICE: ApiService? = null

    fun getApiService(): ApiService? {
        val httpClient = OkHttpClient.Builder()
        val baseUrl = "http://testing.nexoserver.com.ar/bootcampmobile/"
        if (API_SERVICE == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()) // <-- usamos el log level
                .build()
            API_SERVICE = retrofit.create(ApiService::class.java)
        }
        return API_SERVICE
    }
}