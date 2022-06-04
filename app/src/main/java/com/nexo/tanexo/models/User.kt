package com.nexo.tanexo.models


data class User (
    var name : String,
    var lastName : String,
    var email : String,
    var pass : String,
    var idcourse : String?=null,
    var id : Int=0
) {
}