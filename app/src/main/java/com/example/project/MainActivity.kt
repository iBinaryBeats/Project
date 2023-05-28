package com.example.project

import android.content.Intent //startActivity purposes
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signupGroup:Button=findViewById(R.id.regbtn)
        val loginGroup:Button=findViewById(R.id.loginbtn)
        signupGroup.setOnClickListener(){view->
        val intent= Intent(this,signup::class.java)
            this.startActivity(intent)
        }
        loginGroup.setOnClickListener(){view->
            val intent= Intent(this,login::class.java)
            this.startActivity(intent)


        }




    }
}