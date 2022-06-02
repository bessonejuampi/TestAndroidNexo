package com.nexo.tanexo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nexo.tanexo.databinding.ActivityEventBinding
import com.nexo.tanexo.viewmodels.EventViewModel

class EventActivity :AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding
    private var viewModel :EventViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        viewModel = EventViewModel()

        setupList()
    }

    private fun setupList(){
        binding.rvEvent.layoutManager = LinearLayoutManager(this)
        val adapter = EventAdapter(viewModel!!.listEvent)
        binding.rvEvent.adapter = adapter
    }
}