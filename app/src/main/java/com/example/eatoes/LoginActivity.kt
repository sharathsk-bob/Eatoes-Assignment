package com.example.eatoes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity:AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var emailed:EditText
    lateinit var passed:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin=findViewById(R.id.btnLogin)
        emailed=findViewById(R.id.emailed)
        passed=findViewById(R.id.passed)
        initAction()
    }
    fun initAction(){
        btnLogin.setOnClickListener {
            login()
        }


    }
    fun login(){
        val request=UserRequest()
        request.email=emailed.text.toString().trim()
        request.password=passed.text.toString().trim()

        val retro =Retro().getRetroClientInstance().create(Userapi::class.java)
        retro.login(request).enqueue(object:Callback<UserResponse>{
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(
                        this@LoginActivity,
                    "Error:"+t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val user =response.body()
                if(user!=null){
                    if(request.email==user!!.email && request.password==user!!.password){
                        Toast.makeText(this@LoginActivity,"Login Successfull",Toast.LENGTH_LONG).show()
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this@LoginActivity,"Invalid Credentials",Toast.LENGTH_LONG).show()
                    }
                }

            }

        })

    }
}