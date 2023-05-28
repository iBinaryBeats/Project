package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.*
class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val userPhone:EditText=findViewById(R.id.login_ph)
        val userPass:EditText=findViewById(R.id.login_pass)
        val loginbtn:Button=findViewById(R.id.login_btn)
        var dbh=DBHelper(this)

        loginbtn.setOnClickListener(){view->
        val userPhoneText=userPhone.text.toString()
        val userPassText=userPass.text.toString()

            if(TextUtils.isEmpty(userPhoneText) || TextUtils.isEmpty(userPassText)){
                Toast.makeText(this,"Add Phone Number & Password ",Toast.LENGTH_SHORT).show()
            }
            else{
            val checkuser=dbh.checkuserpass(userPhoneText,userPassText)
                if(checkuser==true) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent= Intent(applicationContext,success::class.java)
                    startActivity(intent)

                }

            else{
                    Toast.makeText(this,"Wrong PhoneNumber or password",Toast.LENGTH_SHORT).show()

                }
            }



            }

    }
}