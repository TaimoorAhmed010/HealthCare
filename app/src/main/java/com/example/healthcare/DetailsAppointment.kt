package com.example.healthcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsAppointment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_appointment)

        val doctor = intent.getParcelableExtra<Doctorlists>("doctor")
        if (doctor != null){
            val textView : TextView = findViewById(R.id.dname_home)
            val textViewp : TextView = findViewById(R.id.dpostion_home)

            textView.text = doctor.name
            textViewp.text= doctor.ptdoctor

        }

    }

}