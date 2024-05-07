package com.example.practice_number_3.Data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practice_number_3.Domain.model.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract val taskDao : TaskDao
}