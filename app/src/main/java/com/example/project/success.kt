package com.example.project

import ClothingContract
import android.content.ContentValues
import android.content.Intent
import android.media.tv.TvContract.Channels.CONTENT_URI
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class success : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        val Button :Button=findViewById(R.id.nxtpagebtn)
        Button.setOnClickListener(){view->
            val intent= Intent(this,success2::class.java)
            this.startActivity(intent)
        }
        val contentValues = ContentValues()
        contentValues.put(ClothingContract.ClothingEntry.COLUMN_ID, 1)
        contentValues.put(ClothingContract.ClothingEntry.COLUMN_QUANTITY, 200)
        val uri = contentResolver.insert(CONTENT_URI, contentValues)
        contentValues.put(ClothingContract.ClothingEntry.COLUMN_ID, 2)
        contentValues.put(ClothingContract.ClothingEntry.COLUMN_QUANTITY, 750)

        val Button2:Button=findViewById(R.id.button2)
        Button2.setOnClickListener(){view->

            val intent= Intent(this,gunshirtorder::class.java)
            this.startActivity(intent)
        }
        }
    }