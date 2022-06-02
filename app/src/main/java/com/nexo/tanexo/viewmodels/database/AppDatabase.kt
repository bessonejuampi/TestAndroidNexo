package com.nexo.tanexo.viewmodels.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nexo.tanexo.models.User
import com.nexo.tanexo.viewmodels.database.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UserDAO(): UserDao?

    companion object {
        private val LOCK = Any()

        private const val DATABASE_NAME = "test_database"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(LOCK) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, DATABASE_NAME
                    ).allowMainThreadQueries().build()
                }
            }
            return instance
        }

    }
}