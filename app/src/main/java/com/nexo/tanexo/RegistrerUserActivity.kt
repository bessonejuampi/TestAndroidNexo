package com.nexo.tanexo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.nexo.tanexo.databinding.ActivityNewUserBinding
import com.nexo.tanexo.viewmodels.RegistrerUserViewModel


class RegistrerUserActivity: AppCompatActivity() {
    private lateinit var binding: ActivityNewUserBinding
    private var viewModel: RegistrerUserViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        viewModel=RegistrerUserViewModel(this)


        binding.btRegistrer.setOnClickListener {
            viewModel!!.validation(
                binding.tfName.editText?.text.toString(),
                binding.tfLastName.editText?.text.toString(),
                binding.tfEmail.editText?.text.toString(),
                binding.tfPass.editText?.text.toString(),
            )
        }
        setupViewModelObserver()
        setupEditText()
    }

    private fun setupViewModelObserver() {
        viewModel?.dataValidationMutable?.observe(this, Observer { dataValidation -> dataValidation?.let {
            if(!dataValidation.nameError.isNullOrEmpty()){
                binding.tfName.error = dataValidation.nameError
            }
            if(!dataValidation.lastNameError.isNullOrEmpty()){
                binding.tfLastName.error = dataValidation.lastNameError
            }
            if(!dataValidation.emailError.isNullOrEmpty()){
                binding.tfEmail.error = dataValidation.emailError
            }
            if(!dataValidation.passError.isNullOrEmpty()){
                binding.tfPass.error = dataValidation.passError
            }
        }
        })
    }

    private fun setupEditText() {
        binding.etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfName.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })
        binding.etLastName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfLastName.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })
        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfEmail.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })
        binding.etPass.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfPass.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })
    }
}