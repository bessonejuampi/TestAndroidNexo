package com.nexo.tanexo.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexo.tanexo.R
import com.nexo.tanexo.models.Course
import com.nexo.tanexo.models.ResponseCourse
import com.nexo.tanexo.models.ResponseEvent
import com.nexo.tanexo.retrofit.ApiClient
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouseViewModel(context: Context) : ViewModel() {
    var listCourse = MutableLiveData<List<Course?>?>()
    var apiClinet = ApiClient().getApiService()
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
}


