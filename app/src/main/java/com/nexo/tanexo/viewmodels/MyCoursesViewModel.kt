package com.nexo.tanexo.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexo.tanexo.commos.SharedPreference
import com.nexo.tanexo.models.Course
import com.nexo.tanexo.models.CourseId
import com.nexo.tanexo.models.ResponseCourse
import com.nexo.tanexo.models.ResponseMyCourse
import com.nexo.tanexo.retrofit.ApiClient
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyCoursesViewModel(private val context: Context) : ViewModel() {

    var listCourse = MutableLiveData<List<Course?>?>()
    var MyCourse = MutableLiveData<List<CourseId?>?>()
    var apiClinet = ApiClient().getApiService()
    var sharedPreference = SharedPreference(context)
    fun getMyCourses(){
        viewModelScope.launch {
            val call = apiClinet?.getCourse()
            val callMyCourse = apiClinet?.getInscriptionFromIdUser(sharedPreference.getUserId())
            call?.enqueue(object: Callback<ResponseCourse?> {
                override fun onResponse(call: Call<ResponseCourse?>?, response: Response<ResponseCourse?>?) {
                    listCourse.value =
                        response?.body()?.listCourses
                }

                override fun onFailure(call: Call<ResponseCourse?>?, t: Throwable?) {
                    Log.e("ERROR ",t.toString())
                }
            })
            callMyCourse?.enqueue(object : Callback<ResponseMyCourse?>{
                override fun onResponse(
                    call: Call<ResponseMyCourse?>?,
                    response: Response<ResponseMyCourse?>?
                ) {
                    MyCourse.value = response?.body()?.courses_id
                }

                override fun onFailure(call: Call<ResponseMyCourse?>?, t: Throwable?) {
                    Log.e("ERROR ",t.toString())
                }
            })

        }
    }

}