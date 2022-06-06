package com.nexo.tanexo.models

import com.google.gson.annotations.SerializedName


data class User (
    @SerializedName("apellido") var name : String,
    @SerializedName("nombre") var lastName : String,
    @SerializedName("email") var email : String,
    @SerializedName("contrasenia") var pass : String
) {
}