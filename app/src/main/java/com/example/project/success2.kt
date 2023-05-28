package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class success2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success2)
        val Button: Button = findViewById(R.id.btnCargoPantsAdd)
        Button.setOnClickListener() { view ->
            val intent = Intent(this, cargopantsorder::class.java)
            this.startActivity(intent)
        }
    }






}