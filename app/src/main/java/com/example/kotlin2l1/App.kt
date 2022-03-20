package com.example.kotlin2l1

import android.app.Application
import androidx.room.Room
import com.example.kotlin2l1.data.room.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {
        lateinit var appDatabase: AppDatabase
    }
}