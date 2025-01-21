@file:OptIn(ExperimentalMaterial3Api::class)
package todo.desktop.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import todo.desktop.components.BottomContent
import todo.desktop.components.ToDoList
import todo.desktop.domain.ToDo
import todo.desktop.domain.ToDoRepository

@Composable
fun ToDoScreen(repository: ToDoRepository) {
    val scope = rememberCoroutineScope()
    val todos by repository.getToDos().collectAsState(emptyList())
    ToDoScreenContent(
        todos = todos,
        addTodo = { scope.launch { repository.addToDo(it) } },
        updateTodo = { scope.launch { repository.updateToDo(it) } },
        deleteTodo = { scope.launch { repository.deleteToDo(it) } }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoScreenContent(
    todos: List<ToDo>,
    addTodo: (ToDo) -> Unit,
    updateTodo: (ToDo) -> Unit,
    deleteTodo: (ToDo) -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var selectedTodo by remember { mutableStateOf<ToDo?>(null) }
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("User List") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showBottomSheet = true }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        ToDoList(todos = todos, modifier = Modifier.padding(innerPadding)) { todo ->
            selectedTodo = todo
            showBottomSheet = true
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                BottomContent(
                    todo = selectedTodo,
                    onSave = { todo ->
                        scope.launch {
                            if (selectedTodo == null) {
                                addTodo(todo)
                            } else {
                                updateTodo(todo)
                            }
                            sheetState.hide()
                        }.invokeOnCompletion {
                            showBottomSheet = false
                            selectedTodo = null
                        }
                    },
                    onDelete = { todo ->
                        scope.launch {
                            todo?.let { deleteTodo(it) }
                            sheetState.hide()
                        }.invokeOnCompletion {
                            showBottomSheet = false
                            selectedTodo = null
                        }
                    }
                )
            }
        }
    }
}
