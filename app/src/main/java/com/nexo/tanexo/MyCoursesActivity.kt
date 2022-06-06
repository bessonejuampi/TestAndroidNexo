package com.nexo.tanexo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nexo.tanexo.databinding.ActivityMycoursesBinding
import com.nexo.tanexo.models.Course
import com.nexo.tanexo.models.CourseId
import com.nexo.tanexo.viewmodels.MyCoursesViewModel

class MyCoursesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMycoursesBinding
    private var viewModel: MyCoursesViewModel? = null
    private var allCourseList: List<Course>? = null
    private var allIdCourse : List<CourseId>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMycoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = MyCoursesViewModel(this)
        viewModel?.getMyCourses()

        viewModel!!.listCourse.observe(this, Observer { list ->
            allCourseList = list as List<Course>
            setupList()
        })

        viewModel!!.MyCourse.observe(this, Observer { list ->
            allIdCourse = list as List<CourseId>
            setupList()
        })
    }
    private fun setupList(){
        if (!allCourseList.isNullOrEmpty() && !allIdCourse.isNullOrEmpty()){
            val listMyCourse = arrayListOf<Course>()
            allIdCourse!!.forEach { course_id ->
                allCourseList!!.find { course -> course.id.toString() == course_id.course_id}?.let { listMyCourse.add(it) }
            }
            binding.rvMyCourses.layoutManager = LinearLayoutManager(this)
            val adapter = MyCourseAdapter(listMyCourse)
            binding.rvMyCourses.adapter = adapter
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) { onBackPressed() }
        return super.onOptionsItemSelected(item)
    }
}