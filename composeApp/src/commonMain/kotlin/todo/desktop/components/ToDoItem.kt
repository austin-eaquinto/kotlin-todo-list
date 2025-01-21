package todo.desktop.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import todo.desktop.domain.ToDo

@Composable
fun ToDoItem(todo: ToDo, clicked: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { clicked() }
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // review this
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = todo.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = todo.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = "MORE TODO INFORMATION HERE(TODOITEM.KT)", style = MaterialTheme.typography.bodySmall)
        }
    }
}