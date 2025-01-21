package todo.desktop.domain

import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    fun getToDos(): Flow<List<ToDo>>
    fun getToDoById(id: String): Flow<ToDo?>
    suspend fun addToDo(todo: ToDo)
    suspend fun updateToDo(todo: ToDo)
    suspend fun deleteToDo(todo: ToDo)
}