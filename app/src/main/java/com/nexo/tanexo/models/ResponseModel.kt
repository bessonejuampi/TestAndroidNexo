package com.nexo.tanexo.models

import com.google.gson.annotations.SerializedName

class ResponseModel(
    @SerializedName("error") var error : Boolean,
    @SerializedName("mensaje") var message : String
) {
}