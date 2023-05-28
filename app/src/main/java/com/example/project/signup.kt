package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*



class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val uphone:EditText=findViewById(R.id.signup_pho)
        val upass:EditText=findViewById(R.id.signup_pass)
        val signup_btn:Button=findViewById(R.id.signup_btn)
        var db:DBHelper= DBHelper(this)


        signup_btn.setOnClickListener(){view->
            val uphoneText=uphone.text.toString()
            val upassText=upass.text.toString()

            val savedata=db.insertdata(uphoneText,upassText)

            if(TextUtils.isEmpty(uphoneText) || TextUtils.isEmpty(upassText)){
                Toast.makeText(this,"Add Phone Number & Password ",Toast.LENGTH_SHORT).show()
            }
            else{
            // if not empty :
            if(savedata==true){
                Toast.makeText(this,"Signup Successful",Toast.LENGTH_SHORT).show()
            val intent=Intent(applicationContext,login::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"User Exists",Toast.LENGTH_SHORT).show()
            }
            }
        }
    }
}