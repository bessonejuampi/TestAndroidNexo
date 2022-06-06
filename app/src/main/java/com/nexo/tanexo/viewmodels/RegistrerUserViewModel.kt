package com.nexo.tanexo.viewmodels

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexo.tanexo.EventActivity
import com.nexo.tanexo.LoginActivity
import com.nexo.tanexo.R
import com.nexo.tanexo.commos.DataValidator
import com.nexo.tanexo.commos.validateText
import com.nexo.tanexo.models.ResponseModel
import com.nexo.tanexo.models.User
import com.nexo.tanexo.retrofit.ApiClient
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class RegistrerUserViewModel(private val context : Context): ViewModel() {
    var dataValidationMutable = MutableLiveData<DataValidator?>()
    var apiClinet = ApiClient().getApiService()
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
                val call = apiClinet?.newUser(name,lastName,pass, email)
                call?.enqueue(object: Callback<ResponseModel?> {
                    override fun onResponse(call: Call<ResponseModel?>?, response: Response<ResponseModel?>?) {
                        val result = response?.body()?.error
                        val message = response?.body()?.message
                        if (!result!!){
                            Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
                            val intent = Intent(context, LoginActivity::class.java)
                            context.startActivity(intent)
                        }else{
                            Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<ResponseModel?>?, t: Throwable?) {
                        Toast.makeText(context,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
                    }
                })

            }
            dataValidationMutable.value = dataValidation
        }
    }

}