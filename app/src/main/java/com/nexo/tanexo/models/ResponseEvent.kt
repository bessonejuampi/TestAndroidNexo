package com.nexo.tanexo.models

import com.google.gson.annotations.SerializedName

class ResponseEvent(
    @SerializedName("eventos") var listEvent : List<Event>
) {

}