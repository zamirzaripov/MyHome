package com.example.myhome.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CameraDbModel::class, DoorDbModel::class], version = 2, exportSchema = false)
abstract class MyHomeDatabase: RoomDatabase() {
    abstract fun cameraDao(): CameraDao
    abstract fun doorDao(): DoorDao

    companion object {

        private var db: MyHomeDatabase? = null
        private const val DATABASE_NAME = "my_home_database"
        private val LOCK = Any()

        fun getInstance(context: Context): MyHomeDatabase {
            synchronized(LOCK){
                db?.let{ return it }
                val instance = Room.databaseBuilder(
                    context,
                    MyHomeDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }
    }
}