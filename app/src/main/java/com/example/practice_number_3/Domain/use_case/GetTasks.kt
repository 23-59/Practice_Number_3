package com.example.practice_number_3.Domain.use_case

import com.example.practice_number_3.Data.data_source.TaskDao
import com.example.practice_number_3.Domain.model.Task
import com.example.practice_number_3.Domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetTasks(private val repository: Repository) {

     operator fun invoke():Flow<List<Task>>{
        return repository.getTasks()
    }
}