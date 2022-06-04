package com.nexo.tanexo.retrofit

import com.nexo.tanexo.models.Course
import com.nexo.tanexo.models.Event
import com.nexo.tanexo.models.ResponseCourse
import com.nexo.tanexo.models.ResponseEvent
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("eventos/todos?")
    fun getEvent(): Call<ResponseEvent?>?

    @GET("cursos/todos")
    fun getCourse() : Call<ResponseCourse?>?

    @FormUrlEncoded
   @POST("usuarios/login")
    fun login(
        @Field("email") email: String?,
        @Field("contrasenia") pass: String?
    ): Call<String?>?
}