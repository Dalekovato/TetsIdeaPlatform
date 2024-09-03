package com.example.tetsideaplatform.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ItemDto::class] , version = 1 , exportSchema = false)
abstract class AppDataBase:RoomDatabase() {


    abstract fun itemDao(): ItemDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()
        private const val DB_NAME = "data.db"

        fun getInstance(application: Context): AppDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDataBase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db

            }
        }
    }
}

