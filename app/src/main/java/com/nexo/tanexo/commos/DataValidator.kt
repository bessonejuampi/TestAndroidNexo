package com.nexo.tanexo.commos

class DataValidator (){
    var nameError:String? = null
    var lastNameError:String? = null
    var emailError:String?=null
    var passError:String?=null

    fun isSuccessfully(): Boolean {
        return nameError.isNullOrEmpty() && lastNameError.isNullOrEmpty() && emailError.isNullOrEmpty()
                && passError.isNullOrEmpty()
    }
}