package com.nexo.tanexo.models

import com.google.gson.annotations.SerializedName

data class Course(
    @SerializedName("id") var id:Int,
    @SerializedName("nombre") var nameCouse : String,
    @SerializedName("duracion") var duration : Int,
    @SerializedName("disertante") var lecturer:String,
    @SerializedName("dia_hora") var day_hour : String,
    @SerializedName("evento_id") var idevent : Int
 ) {
}