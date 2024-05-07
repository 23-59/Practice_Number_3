package com.example.practice_number_3.Domain.repository

import com.example.practice_number_3.Domain.model.Task
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getTasks():Flow<List<Task>>

   suspend fun addTask(task: Task)

   suspend fun deleteTask(task: Task)

   suspend fun getNote(id:Int):Task

}