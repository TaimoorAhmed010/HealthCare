package com.example.healthcare

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.healthcare.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  lateinit var auth: FirebaseAuth
    private  lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var imageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val  uid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        binding.saveBtn.setOnClickListener {

            val firstname = binding.firstnametxt.text.toString()
            val lastname = binding.lastnametxt.text.toString()
            val phone = binding.phonetxt.text.toString()

            val user = Users(firstname, lastname, phone)
            if (uid != null){
                databaseReference.child(uid).setValue(user).addOnCompleteListener{

                    if (it.isSuccessful){
                        uploadprofilePic()
                        Toast.makeText(this,"Save data",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, HomeScreen::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Not save data",Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()

            }

        }
    }

    private fun uploadprofilePic() {
        imageUri = Uri.parse("android.resource://$packageName/${R.drawable.doctor}")
        storageReference = FirebaseStorage.getInstance().getReference("Users/"+auth.currentUser?.uid)
        storageReference.putFile(imageUri).addOnSuccessListener {
         Toast.makeText(this,"Profile Save Data",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Upload Image Failed",Toast.LENGTH_SHORT).show()

        }
    }
}