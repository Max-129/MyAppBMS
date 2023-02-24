package com.example.myappbms.taskmanager.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myappbms.taskmanager.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}