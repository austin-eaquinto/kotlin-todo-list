package todo.desktop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform