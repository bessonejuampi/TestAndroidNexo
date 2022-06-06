package com.nexo.tanexo.retrofit

import com.nexo.tanexo.models.*
import retrofit2.Call
import retrofit2.http.*
import java.util.*

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
    ): Call<ResponseLogin?>?

    @FormUrlEncoded
    @POST("usuarios/nuevo")
    fun newUser(
        @Field("apellido") name : String?,
        @Field("nombre") lastName : String?,
        @Field("contrasenia") pass: String?,
        @Field("email") email: String?
    ): Call<ResponseModel?>?

    @GET("inscripciones/{user_id}/{course_id}")
    fun newInscription(
        @Path("user_id") userid : Int?,
        @Path("course_id") courseid : Int?
    ) : Call<ResponseModel?>?

    @GET("inscripciones/{user_id}")
    fun getInscriptionFromIdUser(
        @Path("user_id") userid : Int?
    ): Call<ResponseMyCourse?>?


}