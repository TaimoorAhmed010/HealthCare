package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.healthcare.databinding.ActivityLoginScreenBinding
import com.example.healthcare.databinding.ActivitySignupScreenBinding
import com.google.firebase.auth.FirebaseAuth

class LoginScreen : AppCompatActivity() {

    private lateinit var  binding: ActivityLoginScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener {
            val email = binding.loginEmail.text.toString().trim()
            val password = binding.loginPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()){

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this,"Login Sucessfull", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,HomeScreen::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"This Account is not Registered", Toast.LENGTH_SHORT).show()
                    }
                }

            }else{
                Toast.makeText(this,"Fields does not Empty", Toast.LENGTH_SHORT).show()

            }
        }

        binding.signUpTxt.setOnClickListener {
            val singupIntent = Intent(this,SignupScreen::class.java)
            startActivity(singupIntent)
        }

    }
}