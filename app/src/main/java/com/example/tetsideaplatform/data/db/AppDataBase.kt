package com.example.tetsideaplatform.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tetsideaplatform.data.Converter

@Database(
    entities = [
        ItemDb::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {

        private var INSTANCE: LocalDatabase? = null
        private var LOCK = Any()
        private var DB_NAME = "LocalDatabase"


        fun getInstance(context: Context): LocalDatabase {
            INSTANCE?.let { return it }

            synchronized(LOCK) {
                INSTANCE?.let { return it }

                val database = Room.databaseBuilder(
                    context = context,
                    klass = LocalDatabase::class.java,
                    DB_NAME
                ).createFromAsset("data.db").build()

                INSTANCE = database
                return database
            }
        }
    }
}

