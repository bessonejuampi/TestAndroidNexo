package com.nexo.tanexo.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexo.tanexo.models.Event
import com.nexo.tanexo.models.ResponseEvent
import com.nexo.tanexo.retrofit.ApiClient
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventViewModel(context: Context) : ViewModel() {

    var listEvent = MutableLiveData<List<Event?>?>()
    var apiClinet = ApiClient().getApiService()
    fun getAllEvents(){
        viewModelScope.launch {
            val call = apiClinet?.getEvent()
            call?.enqueue(object: Callback<ResponseEvent?>{
                override fun onResponse(call: Call<ResponseEvent?>?, response: Response<ResponseEvent?>?) {
                    listEvent.value = response?.body()?.listEvent
                }

                override fun onFailure(call: Call<ResponseEvent?>?, t: Throwable?) {
                    Log.e("ERROR EVENTO",t.toString())
                }
            })
        }
    }
}