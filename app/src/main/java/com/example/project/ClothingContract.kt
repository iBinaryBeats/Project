import android.provider.BaseColumns

object ClothingContract {
    // Define table and column names
    object ClothingEntry : BaseColumns {
        const val TABLE_NAME = "Clothing"
        const val COLUMN_ID = "id"
        const val COLUMN_QUANTITY = "quantity"
    }
}
