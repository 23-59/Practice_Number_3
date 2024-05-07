package com.example.practice_number_3.Data.repository

import com.example.practice_number_3.Data.data_source.TaskDao
import com.example.practice_number_3.Domain.model.Task
import com.example.practice_number_3.Domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val taskDao: TaskDao) : Repository {
    override fun getTasks(): Flow<List<Task>> {
        return taskDao.getTasks()
    }

    override suspend fun addTask(task: Task) {
        return taskDao.addTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        return taskDao.deleteTask(task)
    }

    override suspend fun getNote(id: Int): Task {
        return taskDao.getTask(id)
    }


}