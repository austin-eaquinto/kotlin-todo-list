package todo.desktop.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import todo.desktop.domain.ToDo

@Composable
fun ToDoList(todos: List<ToDo>, modifier: Modifier = Modifier, todoClicked: (ToDo) -> Unit) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(todos, key = { it.id }) { todo ->
            ToDoItem(todo = todo) {
                todoClicked(todo)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}