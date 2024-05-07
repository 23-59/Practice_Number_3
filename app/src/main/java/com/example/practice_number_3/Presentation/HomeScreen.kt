package com.example.practice_number_3.Presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.practice_number_3.Domain.util.HomeScreenEvents
import com.example.practice_number_3.Domain.util.Routes
import com.example.practice_number_3.ui.theme.Practice_Number_3Theme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(viewModel: HomeScreenViewModel = hiltViewModel(), navController: NavController) {
    Practice_Number_3Theme {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(onClick = { navController.navigate(Routes.ADD_TASK_SCREEN.value) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                    Text(text = "Add New Task")
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
        ) { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Practice Number 3", modifier = Modifier.padding(top = 24.dp))
                LazyColumn {
                    items(viewModel.taskState.value) { task ->
                        TaskItem(
                            modifier = Modifier.animateItemPlacement(),
                            title = task.title,
                            description = task.description,
                            onDelete = {
                                viewModel.onEvent(HomeScreenEvents.DeleteTask(task))
                            },
                            onEdit = {
                                navController.navigate(Routes.ADD_TASK_SCREEN.value + "?id=${task.id}")
                            })
                    }
                }
            }
        }


    }

}