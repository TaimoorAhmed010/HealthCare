package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Toast
import com.example.healthcare.databinding.ActivitySignupScreenBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class SignupScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySignupScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signupButton.setOnClickListener {

            val email = binding.signupEmail.text.toString()
            val password = binding.signupPassword.text.toString()
            val confrimpassword = binding.signupCpassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confrimpassword.isNotEmpty()){
                if (password == confrimpassword){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this,"Sign Up Sucessfully",Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,"Something Worng, try agian",Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this,"Password does Not Matched",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Fields can not be empty",Toast.LENGTH_SHORT).show()
            }

        }


        binding.signInTxt.setOnClickListener {
            val loginIntent = Intent(this, LoginScreen::class.java)
            startActivity(loginIntent)
        }


    }

}