package com.nexo.tanexo.commos

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(private val context: Context) {

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences("TA-Nexo", Context.MODE_PRIVATE)

    private var editor: SharedPreferences.Editor? = null

    init {
        editor = sharedPreferences.edit()
    }

    private fun save() {
        try {
            editor!!.commit()
        } catch (nullPointerException: NullPointerException) {
            // Nothing use
        }
    }



    fun setUserid(value: Int?){
        val key_userid:String = "user_id"
        try {
            if (value != null) {
                editor!!.putInt(key_userid,value)
            }
            save()
        }catch (nullPointerException : NullPointerException){

        }
    }

    fun getUserId():Int?{
        val key_userid:String = "user_id"
        var value : Int?=null
        try {
            if (sharedPreferences.contains(key_userid)){
                value = sharedPreferences.getInt(key_userid,-1)
            }
        }catch (nullPinterException : NullPointerException){
            //Nothing use
        }
        return value
    }
}
