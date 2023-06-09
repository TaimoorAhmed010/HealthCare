package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeScreen : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var doctorl : ArrayList<Doctorlists>
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        doctorl = ArrayList()

        doctorl.add( Doctorlists("Dr. Asher Alam", "Nephrologist"))
        doctorl.add( Doctorlists("Dr. Mehnaz Atiq Ahmed", "Cardiologist"))
        doctorl.add( Doctorlists("Dr. Muhammad Yosuf", " Radiologist"))
        doctorl.add( Doctorlists("Dr. Naseem Salahuddin", "General Physician"))
        doctorl.add( Doctorlists("Dr. Asher Alam", "Nephrologist"))
        doctorl.add( Doctorlists("Dr. Naveed Anjum", "ENT Specialist"))

        adapter = Adapter(doctorl)
        recyclerView.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, DetailsAppointment::class.java)
            intent.putExtra("doctor",it)
            startActivity(intent)
        }

    }

}