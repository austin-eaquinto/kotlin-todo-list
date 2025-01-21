package todo.desktop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.Clock
import kotlinx.datetime.IllegalTimeZoneException
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import todo.desktop.data.FirestoreToDoRepository
import todo.desktop.domain.ToDo
import todo.desktop.presentation.ToDoScreen

import tododesktop.composeapp.generated.resources.Res
import tododesktop.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    val ToDoRepository = remember { FirestoreToDoRepository()}
    ToDoScreen(ToDoRepository)
//    MaterialTheme {
//        var location by remember { mutableStateOf("Europe/Paris") }
//        var timeAtLocation by remember { mutableStateOf("No location selected") }
//
//        fun currentTimeAt(location: String): String? {
//            fun LocalTime.formatted() = "$hour:$minute:$second"
//
//            return try {
//                val time = Clock.System.now()
//                val zone = TimeZone.of(location)
//                val localTime = time.toLocalDateTime(zone).time
//                "The time in $location is ${localTime.formatted()}"
//            } catch (ex: IllegalTimeZoneException) {
//                null
//            }
//        }
//
//        Column(modifier = Modifier.padding(20.dp)){
//            Text(
//                timeAtLocation,
//                style = TextStyle(fontSize = 20.sp),
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
//            )
//            TextField(
//                value = location,
//                modifier = Modifier.padding(top = 10.dp),
//                onValueChange = { location = it }
//            )
//            Button(
//                modifier = Modifier.padding(top=10.dp),
//                onClick = { timeAtLocation = currentTimeAt(location) ?: "Invalid Location" }) {
//                Text("Show Time")
//            }
//        }
//        var createToDo by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { createToDo = !createToDo }) {
//                Text("Create ToDo")
//            }
//            AnimatedVisibility(createToDo) {
//                Column {
//                    Text("Create ToDo")
//                }
//            }
//        }
//
//        fun todaysDate(): String {
//            fun LocalDateTime.format() = toString().substringBefore('T')
//
//            val now = Clock.System.now()
//            val zone = TimeZone.currentSystemDefault()
//            return now.toLocalDateTime(zone).format()
//        }
//
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Text(
//                text = "Today's date is ${todaysDate()}",
//                modifier = Modifier.padding(20.dp),
//                fontSize = 24.sp,
//                textAlign = TextAlign.Center
//            )
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
}


