package com.nexo.tanexo.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexo.tanexo.R
import com.nexo.tanexo.commos.DataValidator
import com.nexo.tanexo.commos.validateText
import com.nexo.tanexo.models.User
import com.nexo.tanexo.viewmodels.database.AppDatabase
import kotlinx.coroutines.launch

class RegistrerUserViewModel(private val context : Context): ViewModel() {
    var dataValidationMutable = MutableLiveData<DataValidator?>()
    val database = AppDatabase.getInstance(context)
    val userDao = database?.UserDAO()
    fun validation(name:String?, lastName:String?, email:String?, pass:String?){
        viewModelScope.launch {
            var dataValidation = DataValidator()
            if(!name.validateText()){
                dataValidation.nameError = context.getString(R.string.errorMessage)
            }
            if(!lastName.validateText()){
                dataValidation.lastNameError = context.getString(R.string.errorMessage)
            }
            if(!email.validateText()){
                dataValidation.emailError = context.getString(R.string.errorMessage)
            }
            if(!pass.validateText()){
                dataValidation.passError = context.getString(R.string.errorMessage)
            }
            if (dataValidation.isSuccessfully()){
                val user = User(name!!, lastName!!, email!!, pass!!)
                userDao?.insertUser(user)
                Toast.makeText(context, "Usuario registrado!!", Toast.LENGTH_SHORT).show()
            }
            dataValidationMutable.value = dataValidation
        }
    }
}