package com.nexo.tanexo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nexo.tanexo.databinding.ActivityLoginBinding
import com.nexo.tanexo.viewmodels.LoginViewModel


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var viewModel:  LoginViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var viewModel = LoginViewModel()
        binding.btLogIn.setOnClickListener {
            if (binding.etEmail.text.toString().isNullOrEmpty() || binding.etPass.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "Por favor, ingrese sus datos", Toast.LENGTH_SHORT).show()
            }else{
               if(!viewModel.logIn(binding.etEmail.text.toString(), binding.etPass.text.toString())){
                   val intent = Intent(this, EventActivity::class.java)
                   startActivity(intent)
               }
            }
        }

        binding.btNewuser.setOnClickListener{
            val intent = Intent(this, RegistrerUserActivity::class.java)
            startActivity(intent)
        }



    }


}