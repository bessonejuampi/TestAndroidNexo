package com.nexo.tanexo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nexo.tanexo.databinding.ActivityCouseBinding
import com.nexo.tanexo.models.Course
import com.nexo.tanexo.viewmodels.CouseViewModel

class CourseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCouseBinding
    private var viewModel: CouseViewModel? = null
    private lateinit var courseList: List<Course>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCouseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = CouseViewModel(this)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        val idEvent : Int = intent.extras!!.getInt("id_event")

        viewModel!!.listCourse.observe(this, Observer { list ->
            courseList = list as List<Course>
            setupList()
        })

        viewModel!!.getCourse(idEvent)

    }

    private fun setupList(){
        binding.rvCouse.layoutManager = LinearLayoutManager(this)
        val adapter = CouseAdapter(courseList)
        binding.rvCouse.adapter = adapter
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) { onBackPressed() }
        return super.onOptionsItemSelected(item)
    }
}