package com.nexo.tanexo.viewmodels

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nexo.tanexo.EventActivity
import com.nexo.tanexo.LoginActivity
import com.nexo.tanexo.RegistrerUserActivity
import com.nexo.tanexo.commos.SharedPreference
import com.nexo.tanexo.models.ResponseEvent
import com.nexo.tanexo.models.ResponseLogin
import com.nexo.tanexo.models.User
import com.nexo.tanexo.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val context: Context) : ViewModel() {
    var apiClinet = ApiClient().getApiService()
    var sharedPreference = SharedPreference(context)
    fun logIn(emial: String, pass: String) {
        val call = apiClinet?.login(emial, pass)
        call?.enqueue(object : Callback<ResponseLogin?> {
            override fun onResponse(call: Call<ResponseLogin?>?, response: Response<ResponseLogin?>?) {
                sharedPreference.setUserid(response!!.body()?.userId)
                val result = response.body()?.error
                val message = response.body()?.message
                if (!result!!){
                    val intent = Intent(context, EventActivity::class.java)
                    context.startActivity(intent)
                }else {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                }
                }

            override fun onFailure(call: Call<ResponseLogin?>?, t: Throwable?) {
                Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}