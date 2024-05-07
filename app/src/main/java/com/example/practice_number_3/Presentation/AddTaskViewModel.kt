package com.example.practice_number_3.Presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice_number_3.Domain.model.Task
import com.example.practice_number_3.Domain.use_case.AddTask
import com.example.practice_number_3.Domain.use_case.GetTask
import com.example.practice_number_3.Domain.util.AddScreenEvents
import com.example.practice_number_3.Domain.util.AddScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val addTask: AddTask,
    getTask: GetTask,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var currentNoteId: Int? = null

    private val _addTaskState = mutableStateOf(AddScreenState())
    val addTaskState: State<AddScreenState> = _addTaskState

    init {
        savedStateHandle.get<Int>("id")?.let { id ->
            if (id != -1) {
                viewModelScope.launch {
                    getTask(id).also { task ->
                        currentNoteId = task.id
                        _addTaskState.value = addTaskState.value.copy(
                            title = task.title,
                            description = task.description
                        )
                    }
                }

            }
        }
    }

    fun onEvent(event: AddScreenEvents) {
        when (event) {
            is AddScreenEvents.EnteredTitle -> {
                _addTaskState.value = addTaskState.value.copy(title = event.title)
            }

            is AddScreenEvents.EnteredDescription -> {
                _addTaskState.value = addTaskState.value.copy(description = event.description)
            }

            is AddScreenEvents.Save -> {
                viewModelScope.launch {
                    addTask(
                        Task(id = currentNoteId,
                            title = addTaskState.value.title,
                            description = addTaskState.value.description
                        )
                    )
                }

            }
        }
    }

}