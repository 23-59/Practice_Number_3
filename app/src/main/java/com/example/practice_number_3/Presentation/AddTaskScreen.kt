package com.example.practice_number_3.Presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.practice_number_3.Domain.util.AddScreenEvents

@Composable
fun AddTask(
    navController: NavController,
    viewModel: AddTaskViewModel = hiltViewModel()
) {
    Surface(Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = viewModel.addTaskState.value.title,
                onValueChange = { viewModel.onEvent(AddScreenEvents.EnteredTitle(it)) },
                placeholder = {
                    Text(text = "Enter Title")
                })

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = viewModel.addTaskState.value.description,
                onValueChange = { viewModel.onEvent(AddScreenEvents.EnteredDescription(it)) }, placeholder = {
                    Text(text = "Enter Description")
                })

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                viewModel.onEvent(AddScreenEvents.Save)
                navController.navigateUp()
            }, modifier = Modifier.fillMaxWidth(0.7f)) {
                Text(text = "Save The Task")
            }

        }
    }
}
