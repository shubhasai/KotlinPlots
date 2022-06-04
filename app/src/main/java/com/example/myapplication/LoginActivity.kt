package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    var firebaseauth:FirebaseAuth?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        firebaseauth = FirebaseAuth.getInstance()
        var curuser:FirebaseUser? = firebaseauth!!.currentUser
        binding.btnlogin.setOnClickListener {
            val email = binding.etlgnEmail.text.toString()
            val password = binding.etlgnPass.text.toString()
            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Enter All Fields", Toast.LENGTH_SHORT).show()
            }
            else{
                firebaseauth?.signInWithEmailAndPassword(email,password)?.addOnCompleteListener{
                    if(it.isSuccessful){
                        varifyemail()
                        finish()
                    }
                    else{
                        Toast.makeText(this, "Enter Correct Credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        binding.tvregister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        setContentView(binding.root)
    }
    private fun varifyemail(){
        val firebaseuser = FirebaseAuth.getInstance().currentUser
        val vmail = firebaseuser!!.isEmailVerified
        if(vmail){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        else{
            Toast.makeText(this,"Verify Email",Toast.LENGTH_SHORT).show()
            firebaseauth?.signOut()
        }
    }
}