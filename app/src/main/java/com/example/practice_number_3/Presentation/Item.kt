package com.example.practice_number_3.Presentation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskItem(modifier: Modifier = Modifier,title: String, description: String, onDelete: () -> Unit,onEdit:() -> Unit) {
    Card(modifier =  modifier.padding(all = 10.dp), onClick = onEdit) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text =title, modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 16.dp))
            Text(text =description, modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp))
            IconButton(onClick = { onDelete() }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskItemPreview(modifier: Modifier = Modifier) {
    TaskItem(title = "title", description = "description", onEdit = {}, onDelete = {})
}