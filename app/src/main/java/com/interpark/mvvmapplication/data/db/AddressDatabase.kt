package com.interpark.mvvmapplication.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.interpark.mvvmapplication.data.db.dao.AddressDao
import com.interpark.mvvmapplication.data.db.entity.Address

@Database(entities = [Address::class], version = AddressDatabase.DB_VERSION, exportSchema = false)
abstract class AddressDatabase : RoomDatabase() {
    abstract fun getAddressDao(): AddressDao

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "mvvm.db"
        @Volatile
        private var INSTANCE: AddressDatabase? = null

        fun getInstance(context: Context): AddressDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context.applicationContext, AddressDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2)
                .build()

        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}