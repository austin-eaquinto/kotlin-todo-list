package todo.desktop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import todo.desktop.data.FirestoreToDoRepository
import todo.desktop.domain.ToDo
import todo.desktop.presentation.ToDoScreen

@Composable
@Preview
fun App() {
    val todoRepository = remember { FirestoreToDoRepository() }
    val todoItems = remember { mutableStateListOf<Pair<String, Boolean>>() }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("To-Do List") })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the to-do list
            if (todoItems.isEmpty()) {
                Text("Your to-do list is empty.")
            } else {
                todoItems.forEachIndexed { index, item ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = item.second,
                            onCheckedChange = {
                                todoItems[index] = item.copy(second = it)
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = item.first,
                            style = TextStyle(fontSize = 18.sp),
                            modifier = Modifier.weight(1f)
                        )
                        TextButton(onClick = { todoItems.removeAt(index) }) {
                            Text("Delete")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Add new to-do item
            var newItem by remember { mutableStateOf("") }
            TextField(
                value = newItem,
                onValueChange = { newItem = it },
                label = { Text("New To-Do Item") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    if (newItem.isNotBlank()) {
                        todoItems.add(Pair(newItem, false))
                        newItem = ""
                    }
                }
            ) {
                Text("Add Item")
            }
        }
    }
}