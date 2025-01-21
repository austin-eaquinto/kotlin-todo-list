package todo.desktop.domain

import kotlinx.serialization.Serializable

@Serializable
data class ToDo(
    val id: String,
    val title: String,
    val description: String,
    val done: Boolean
)
