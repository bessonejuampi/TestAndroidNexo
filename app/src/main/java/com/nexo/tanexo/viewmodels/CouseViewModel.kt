package com.nexo.tanexo.viewmodels

import android.app.SharedElementCallback
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexo.tanexo.LoginActivity
import com.nexo.tanexo.R
import com.nexo.tanexo.commos.SharedPreference
import com.nexo.tanexo.models.Course
import com.nexo.tanexo.models.ResponseCourse
import com.nexo.tanexo.models.ResponseEvent
import com.nexo.tanexo.models.ResponseModel
import com.nexo.tanexo.retrofit.ApiClient
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CouseViewModel(private val context: Context) : ViewModel() {
    var listCourse = MutableLiveData<List<Course?>?>()
    var apiClinet = ApiClient().getApiService()
    var sharedPreference = SharedPreference(context)
    fun getCourse(idEvent : Int){
        viewModelScope.launch {
            val call = apiClinet?.getCourse()
            call?.enqueue(object: Callback<ResponseCourse?> {
                override fun onResponse(call: Call<ResponseCourse?>?, response: Response<ResponseCourse?>?) {
                    listCourse.value =
                        response?.body()?.listCourses?.filter {course -> course.idevent==idEvent }
                }

                override fun onFailure(call: Call<ResponseCourse?>?, t: Throwable?) {
                    Log.e("ERROR EVENTO",t.toString())
                }
            })
        }
    }

    fun getNewInscripction(courseId : Int) {
        val userId = sharedPreference.getUserId()
        val call = apiClinet?.newInscription(userId, courseId)
        call?.enqueue(object : Callback<ResponseModel?>{
            override fun onResponse(call: Call<ResponseModel?>?, response: Response<ResponseModel?>?) {
                val result = response?.body()?.error
                val message = response?.body()?.message
                if (!result!!){
                    Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseModel?>?, t: Throwable?) {
                Toast.makeText(context,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}


