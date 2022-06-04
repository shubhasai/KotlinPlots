package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var firebaseregister: FirebaseAuth?=null
    private var uemail:String?=null
    private var upass:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        binding.btnregister.setOnClickListener {
            uemail = binding.etrgtemail.text.toString()
            upass = binding.etrgtpass.text.toString()
            register()
        }
        firebaseregister = FirebaseAuth.getInstance()
        setContentView(binding.root)
    }
    private fun register(){
        val email: String? = uemail
        val password: String? = upass
        if(email!!.isEmpty() || password!!.isEmpty()){
            Toast.makeText(this,"Enter All Fields", Toast.LENGTH_SHORT).show()
        }
        else{
            firebaseregister!!.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{ task->
                    if(task.isSuccessful){
                        checkemail()
                    } else{
                        Toast.makeText(this,email.toString()+password.toString(),Toast.LENGTH_SHORT).show()
                        Log.e("SG","RG error:"+(task.exception!!.message))
                    }
                }
        }
    }
    private fun checkemail(){
        val firebaseuser = Firebase.auth.currentUser
        firebaseuser?.sendEmailVerification()?.addOnCompleteListener { task->
            if(task.isSuccessful){
                Toast.makeText(this,"Verification Mail Sent",Toast.LENGTH_SHORT).show()
                firebaseregister?.signOut()
                finish()
                startActivity(Intent(this,LoginActivity::class.java))
            }
            else{
                Toast.makeText(this,"Verification Mail Not Sent. Something Went wrong!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}