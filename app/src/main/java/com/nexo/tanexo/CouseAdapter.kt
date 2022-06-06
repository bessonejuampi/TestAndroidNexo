package com.nexo.tanexo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nexo.tanexo.databinding.CouseCardBinding
import com.nexo.tanexo.models.Course
import com.nexo.tanexo.viewmodels.CouseViewModel

class CouseAdapter(
    private val listCouse:List<Course>
) : RecyclerView.Adapter<CouseAdapter.CouseViewHolder>(){

    override fun getItemCount(): Int = listCouse.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouseViewHolder {
        val binding = CouseCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CouseViewHolder(binding,parent.context)
    }

    override fun onBindViewHolder(holder: CouseViewHolder, position: Int) {
        holder.bind(listCouse[position])
    }

    inner class CouseViewHolder(
        private val itemView : CouseCardBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(itemView.root){
        fun bind(couse: Course){
            val viewModel=  CouseViewModel(context)
            itemView.findViewById<LinearLayout>(R.id.llCardCouse).apply {
                this.findViewById<TextView>(R.id.tvNameCouse).text = couse.nameCouse
                this.findViewById<TextView>(R.id.tvDuration).text = "Duracion: " + couse.duration.toString()
                this.findViewById<TextView>(R.id.tvLecturer).text = "Disertante: "+couse.lecturer
                this.findViewById<TextView>(R.id.tvDayHour).text = couse.day_hour
                this.findViewById<Button>(R.id.btInscription).setOnClickListener {
                    viewModel.getNewInscripction(couse.id)

                }
            }
        }


    }
}