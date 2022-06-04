package com.nexo.tanexo.viewmodels

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nexo.tanexo.LoginActivity
import com.nexo.tanexo.RegistrerUserActivity
import com.nexo.tanexo.models.ResponseEvent
import com.nexo.tanexo.models.User
import com.nexo.tanexo.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel() : ViewModel() {
    var apiClinet = ApiClient().getApiService()
    fun logIn(emial:String, pass : String):Boolean{
        val call = apiClinet?.login(emial, pass)
        var result : Boolean = false
        call?.enqueue(object: Callback<String?> {
            override fun onResponse(call: Call<String?>?, response: Response<String?>?) {
                result = response?.isSuccessful?:false
            }

            override fun onFailure(call: Call<String?>?, t: Throwable?) {
                result = false
            }
        })
        return result
        }
    }