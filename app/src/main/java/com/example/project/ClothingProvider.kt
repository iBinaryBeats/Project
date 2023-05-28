package com.example.project

import ClothingContract
import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri

class ClothingProvider : ContentProvider() {
    private lateinit var dbHelper: DatabaseHelper
    companion object {
        private const val DATABASE_NAME = "PandB.db"
        private const val DATABASE_VERSION = 1
    }
    // Constants for the content provider URI
    private val AUTHORITY = "com.example.provider"
    private val PATH_CLOTHING = "clothing"
    private val CONTENT_URI = Uri.parse("content://$AUTHORITY/$PATH_CLOTHING")

    // Constants for the URI matcher
    private val CLOTHING = 1
    private val CLOTHING_ID = 2
    private val uriMatcher: UriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    init {
        uriMatcher.addURI(AUTHORITY, PATH_CLOTHING, CLOTHING)
        uriMatcher.addURI(AUTHORITY, "$PATH_CLOTHING/#", CLOTHING_ID)
    }

    override fun onCreate(): Boolean {
        dbHelper = context?.let { DatabaseHelper(it) }!!
        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val database = dbHelper.writableDatabase
        val id = database.insert(ClothingContract.ClothingEntry.TABLE_NAME, null, values)
        database.close()

        return ContentUris.withAppendedId(CONTENT_URI, id)
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    // Implement the remaining methods (update, delete, query) if needed

    // Database helper class
    private inner class DatabaseHelper(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        override fun onCreate(db: SQLiteDatabase) {
            val SQL_CREATE_CLOTHING_TABLE = "CREATE TABLE " +
                    ClothingContract.ClothingEntry.TABLE_NAME + " (" +
                    ClothingContract.ClothingEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ClothingContract.ClothingEntry.COLUMN_QUANTITY + " INTEGER NOT NULL);"
            db.execSQL(SQL_CREATE_CLOTHING_TABLE)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            // Handle database upgrades if needed
        }


    }


}
