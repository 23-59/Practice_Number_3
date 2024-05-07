package com.example.practice_number_3.Domain.util

import com.example.practice_number_3.Domain.model.Task

sealed class HomeScreenEvents {

    data class DeleteTask(val task: Task):HomeScreenEvents()

    data object GetTasks : HomeScreenEvents()
}