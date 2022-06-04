package com.nexo.tanexo.models

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("id") var id :Int ,
    @SerializedName("nombre") var nameEvent : String,
    @SerializedName("descripcion") var description :String,
    @SerializedName("lugar") var place :String,
    @SerializedName("fecha_inicio") var startDate : String,
    @SerializedName("fecha_fin") var endDate : String
) {
}