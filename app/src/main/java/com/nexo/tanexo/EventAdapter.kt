package com.nexo.tanexo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.nexo.tanexo.databinding.EventCardBinding
import com.nexo.tanexo.models.Event

class EventAdapter(
    private val listEvents:List<Event>
) :RecyclerView.Adapter<EventAdapter.EventViewHolder>(){

    override fun getItemCount()=listEvents.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(listEvents[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = EventCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EventViewHolder(binding,parent.context)
    }
    inner class EventViewHolder(
        private val itemView : EventCardBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(itemView.root){
        fun bind(event: Event){
            itemView.findViewById<LinearLayout>(R.id.llCardEvent).apply {
                this.findViewById<TextView>(R.id.tvNameEvent).text = event.nameEvent
                this.findViewById<TextView>(R.id.tvPlace).text = event.place
                this.findViewById<TextView>(R.id.tvDescription).text = event.description
            }
        }


    }
}