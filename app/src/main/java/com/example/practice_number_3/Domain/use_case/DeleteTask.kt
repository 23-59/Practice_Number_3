package com.example.practice_number_3.Domain.use_case

import com.example.practice_number_3.Domain.model.Task
import com.example.practice_number_3.Domain.repository.Repository

class DeleteTask(private val repository: Repository) {

    suspend operator fun invoke(task: Task){
        repository.deleteTask(task)
    }
}