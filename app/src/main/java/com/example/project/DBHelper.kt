package com.example.project

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context:Context):SQLiteOpenHelper(context,"Userdata",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
     p0?.execSQL("create table Userdata(phone TEXT primary key,password TEXT)")


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
   p0?.execSQL("drop table if exists Userdata")

    }
    fun insertdata(phone_number:String,pass:String):Boolean{
     val p0=this.writableDatabase
        val cv=ContentValues()
        cv.put("phone",phone_number)
        cv.put("password",pass)
        val result=p0.insert("Userdata",null,cv)
        if(result==-1.toLong()){
            return false;
        }
        return true;

    }
    fun checkuserpass(phone_number:String,pass:String):Boolean{
        val p0=this.writableDatabase
        val query="select * from Userdata where phone='$phone_number'and password='$pass'"
        val cursor=p0.rawQuery(query,null)
        if(cursor.count<=0){
            cursor.close()
            return false
        }
    cursor.close()
        return true
    }

}