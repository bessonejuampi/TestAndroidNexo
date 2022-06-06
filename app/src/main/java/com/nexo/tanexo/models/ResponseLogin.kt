package com.nexo.tanexo.models

import com.google.gson.annotations.SerializedName

class ResponseLogin(
    @SerializedName("error") var error : Boolean,
    @SerializedName("mensaje") var message : String,
    @SerializedName("userid") var userId : Int,
    @SerializedName("token") var token : String
) {
}