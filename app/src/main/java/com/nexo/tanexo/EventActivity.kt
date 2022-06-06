package com.nexo.tanexo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nexo.tanexo.databinding.ActivityEventBinding
import com.nexo.tanexo.models.Event
import com.nexo.tanexo.viewmodels.EventViewModel

class EventActivity :AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding
    private var viewModel: EventViewModel? = null
    private lateinit var eventsList: List<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }


        viewModel = EventViewModel(this)

        viewModel!!.listEvent.observe(this, Observer { list ->
            eventsList = list as List<Event>
            setupList()
        })

        viewModel!!.getAllEvents()
    }

    private fun setupList() {
        binding.rvEvent.layoutManager = LinearLayoutManager(this)
        val adapter = EventAdapter(eventsList)
        adapter.onEventClick={idEvent ->
            val intent = Intent(this, CourseActivity::class.java)
            intent.putExtra("id_event", idEvent)
            startActivity(intent)
        }
        binding.rvEvent.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_user,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) { onBackPressed() }
        if (item.itemId == R.id.MyCourses){
            val intent = Intent(this, MyCoursesActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}