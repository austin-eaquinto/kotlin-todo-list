package todo.desktop.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.flow
import todo.desktop.domain.ToDo
import todo.desktop.domain.ToDoRepository


class FirestoreToDoRepository : ToDoRepository {
    private val firestore = Firebase.firestore

    override fun getToDos() = flow {
        firestore.collection("todos").snapshots.collect { querySnapshot ->
            val todos = querySnapshot.documents.map { documentSnapshot ->
                documentSnapshot.data<ToDo>()
            }
            emit(todos)
        }
    }
    override fun getToDoById(id: String) = flow {
        firestore.collection("todos").document(id).snapshots.collect { documentSnapshot ->
            emit(documentSnapshot.data<ToDo>())
        }
    }
    override suspend fun addToDo(todo: ToDo) {
        val todoId = generateRandomStringId()
        firestore.collection("todos")
            .document(todoId)
            .set(todo.copy(id = todoId))
    }
    override suspend fun updateToDo(todo: ToDo) {
        firestore.collection("todos").document(todo.id).set(todo)
    }
    override suspend fun deleteToDo(todo: ToDo) {
        firestore.collection("todos").document(todo.id).delete()
    }
    private fun generateRandomStringId(length: Int = 20): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length).map { allowedChars.random() }.joinToString("")
    }
}