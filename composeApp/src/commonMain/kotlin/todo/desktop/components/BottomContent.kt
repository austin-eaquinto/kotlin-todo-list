@file:OptIn(ExperimentalMaterial3Api::class)

package todo.desktop.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import todo.desktop.domain.ToDo

@Composable
fun BottomContent(
    todo: ToDo? = null,
    onSave: (ToDo) -> Unit,
    onDelete: (ToDo?) -> Unit
) {
    var title by remember { mutableStateOf(todo?.title ?: "") }
    var description by remember { mutableStateOf(todo?.description ?: "") }
    // more ToDo information here

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { title = it },
            singleLine = true,
            label = { Text("Title") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        // more ToDo information here
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onSave(ToDo(id = todo?.id ?: "", title, description, done = todo?.done ?: false)) }) {
                Text(text = if (todo == null) "Save" else "Update")
            }
            Button(onClick = { onDelete(todo) }) {
                Text("Delete")
            }
        }
    }
}