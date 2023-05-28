package com.example.project
import ClothingContract
import android.content.ContentValues
import android.media.tv.TvContract
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class cargopantsorder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cargopantsorder)
        val Button:Button=findViewById(R.id.ordercargobtn)
        val quantity: EditText = findViewById(R.id.cargopantstxt)
        Button.setOnClickListener(){
            val n = quantity.toString().toInt()
            subtractFromDatabase(n)



        }
    }

    private fun subtractFromDatabase(n: Int) {
        val requiredQuantity:Int = n

        val contentResolver = contentResolver

        // Query the current quantity from the database
        val projection = arrayOf(ClothingContract.ClothingEntry.COLUMN_QUANTITY)
        val cursor = contentResolver.query(TvContract.Channels.CONTENT_URI, projection, null, null, null)
        var currentQuantity = 0

        cursor?.use {
            if (it.moveToFirst()) {
                val currentQuantityIndex =
                    it.getColumnIndex(ClothingContract.ClothingEntry.COLUMN_QUANTITY)
                currentQuantity = it.getInt(currentQuantityIndex)
            }
        }

        // Subtract the required quantity from the current quantity
        val updatedQuantity = currentQuantity - requiredQuantity

        // Update the value in the database
        val contentValues = ContentValues()
        contentValues.put(ClothingContract.ClothingEntry.COLUMN_QUANTITY, updatedQuantity)
        val selection = "${ClothingContract.ClothingEntry.COLUMN_ID} = ?"
        val selectionArgs = arrayOf("2") // Assuming you want to update the row with id=1

        contentResolver.update(TvContract.Channels.CONTENT_URI, contentValues, selection, selectionArgs)
    }
    }
