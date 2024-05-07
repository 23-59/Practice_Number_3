package com.example.practice_number_3.Presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice_number_3.Domain.model.Task
import com.example.practice_number_3.Domain.use_case.DeleteTask
import com.example.practice_number_3.Domain.use_case.GetTasks
import com.example.practice_number_3.Domain.util.HomeScreenEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getTasks: GetTasks,
    private val deleteTask: DeleteTask,
) : ViewModel() {
    private val taskJob: Job? = null

    private val _taskState = mutableStateOf(listOf<Task>())
    val taskState: State<List<Task>> = _taskState

    init {
        taskJob?.cancel()
        getTasks().onEach { tasks ->
            _taskState.value = tasks
        }.launchIn(viewModelScope)
    }

    fun onEvent(events: HomeScreenEvents) {

        when (events) {
            is HomeScreenEvents.DeleteTask -> {
                viewModelScope.launch {
                    deleteTask(events.task)
                }
            }
            is HomeScreenEvents.GetTasks -> {
                taskJob?.cancel()
                getTasks().onEach { tasks ->
                    _taskState.value = tasks
                }.launchIn(viewModelScope)
            }
        }
    }
}