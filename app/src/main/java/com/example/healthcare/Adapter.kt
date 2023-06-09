package com.example.healthcare

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private var doctorl: ArrayList<Doctorlists>)
    : RecyclerView.Adapter<Adapter.DoctorViewHolder>(){

    var onItemClick : ((Doctorlists) -> Unit)? = null

    class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textView : TextView = itemView.findViewById(R.id.dname_home)
        val ptextView : TextView = itemView.findViewById(R.id.dpostion_home)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return DoctorViewHolder(view)
    }

     override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctorl[position]
        holder.textView.text = doctor.name
        holder.ptextView.text = doctor.ptdoctor

         holder.itemView.setOnClickListener {
             onItemClick?.invoke(doctor)
         }

    }

    override fun getItemCount(): Int {
        return doctorl.size
    }


}
