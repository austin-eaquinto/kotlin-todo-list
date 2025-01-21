package todo.desktop

import android.app.Application
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.google.firebase.FirebasePlatform
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.initialize

fun main() = application {

    FirebasePlatform.initializeFirebasePlatform(object : FirebasePlatform() {

        val storage = mutableMapOf<String, String>()
        override fun clear(key: String) {
            storage.remove(key)
        }

        override fun log(msg: String) = println(msg)

        override fun retrieve(key: String) = storage[key]

        override fun store(key: String, value: String) = storage.set(key, value)

    })

    val options = FirebaseOptions(
        projectId = "kotlin-to-do-5afeb",
        applicationId = "1:512577602896:web:d3ebae6c8bb55e59839855",
        apiKey = "AIzaSyAp-XE1h9EWiM1pJ3fNaitPb3xwdB1QTdw"
    )
    Firebase.initialize(Application(), options)

    Window(
        onCloseRequest = ::exitApplication,
        title = "To-Do Application",
    ) {
        App()
    }
}

// Change the window size and position
//fun main() = application {
//    val state = rememberWindowState(
//        size = DpSize(400.dp, 250.dp),
//        position = WindowPosition(300.dp, 300.dp)
//    )
//    Window(title = "Local Time App", onCloseRequest = ::exitApplication, state = state) {
//        App()
//    }
//}