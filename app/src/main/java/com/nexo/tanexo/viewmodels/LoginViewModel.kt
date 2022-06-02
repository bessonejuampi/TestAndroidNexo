package com.nexo.tanexo.viewmodels

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nexo.tanexo.LoginActivity
import com.nexo.tanexo.RegistrerUserActivity
import com.nexo.tanexo.models.User
import com.nexo.tanexo.viewmodels.database.AppDatabase
import com.nexo.tanexo.viewmodels.database.dao.UserDao

class LoginViewModel(context: Context) : ViewModel() {
    var user = MutableLiveData<User?>()
    val database = AppDatabase.getInstance(context)
    val userDAO : UserDao = database?.UserDAO()!!

    fun LogIn(email:String, pass:String, context : Context):Boolean{
        val user : User = userDAO.loginUser(email,pass)
        if (user==null){
            Toast.makeText(context, "Usuario o contraseña invalida", Toast.LENGTH_SHORT).show()
            return true
        }else{
            return false
        }
    }


}