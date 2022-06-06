package com.nexo.tanexo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nexo.tanexo.databinding.MycoursesCardBinding
import com.nexo.tanexo.models.Course

class MyCourseAdapter(
    private val listCouse:List<Course>
) : RecyclerView.Adapter<MyCourseAdapter.MyCoursesViewHolder>(){
    inner class MyCoursesViewHolder(
        private val itemView : MycoursesCardBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(itemView.root){
        fun bind(course: Course) = with(itemView){
            itemView.findViewById<LinearLayout>(R.id.llCardMyCouse).apply {
                this.findViewById<TextView>(R.id.tvNameMyCouse).text = course.nameCouse
                this.findViewById<TextView>(R.id.tvMyDuration).text = course.duration.toString()
                this.findViewById<TextView>(R.id.tvMyLecturer).text = course.lecturer
                this.findViewById<TextView>(R.id.tvMyDayHour).text = course.day_hour
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCoursesViewHolder {
        val binding = MycoursesCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyCoursesViewHolder(binding,parent.context)
    }

    override fun onBindViewHolder(holder: MyCoursesViewHolder, position: Int) {
        holder.bind(listCouse[position])
    }

    override fun getItemCount(): Int = listCouse.size
}