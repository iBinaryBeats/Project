import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ClothingDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "PandB.db"
        private const val DATABASE_VERSION = 1

        private const val SQL_CREATE_ENTRIES = "CREATE TABLE ${ClothingContract.ClothingEntry.TABLE_NAME} (" +
                "${ClothingContract.ClothingEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${ClothingContract.ClothingEntry.COLUMN_QUANTITY} INTEGER)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${ClothingContract.ClothingEntry.TABLE_NAME}"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}
