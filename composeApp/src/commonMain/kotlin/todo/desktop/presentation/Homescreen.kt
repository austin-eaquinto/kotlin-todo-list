package todo.desktop.presentation

fun main() {
    val menu = Menu()

    println("Welcome to your to do list.")
    println("Pick a number from the following list.")

    var option: String? = null

    while (option != "5") {
        println("1. View\n2. Add\n3. Check item as done\n4. Delete\n5. Quit")
        print("Enter a number: ")
        option = readln()

        when (option) {
            "1" -> menu.display()
            "2" -> {
                print("Add item: ")
                val item = readLine() ?: ""
                menu.addItem(item)
            }

            "3" -> {
//                println("Marked as complete")
                print("Enter the number of the item to mark as done: ")
                val index = readLine()?.toIntOrNull()
                if (index != null) {
                    menu.markItemAsDone(index)
                } else {
                    println("Invalid option.")
                }
            }
            "4" -> {
                print("Remove item number: ")
                val index = readLine()?.toIntOrNull()
                if (index != null) {
                    menu.deleteItem(index)
                } else {
                    println("Invalid option.")
                }
            }
            "5" -> {
                println("Saving...\nGoodbye")
                // add functionality to save before end program.
                break // breaks out of loop
            }
            else -> println("Invalid option. Please select from the list.")
        }
    }
}

class Menu {
    private val todoList = mutableListOf<Pair<String, Boolean>>()

    fun display() {
        if (todoList.isEmpty()) {
            println("Your to-do list is empty.")
        } else {
            println("Your to-do list:")
            todoList.forEachIndexed { index, item ->
                val status = if (item.second) "[Done]" else "[Pending]"
                println("${index + 1}. ${item.first} $status")
            }
        }
    }

    fun addItem(item: String) {
        todoList.add(Pair(item, false))
        println("Item '$item' added.")
    }

    fun markItemAsDone(index: Int) {
        if (index in 1..todoList.size) {
            todoList[index - 1] = todoList[index - 1].copy(second = true)
            println("Item '${todoList[index - 1].first}' marked as done.")
        } else {
            println("Invalid index.")
        }
    }

    fun deleteItem(index: Int) {
        if (index in 1..todoList.size) {
            val removedItem = todoList.removeAt(index - 1)
            println("Item '${removedItem.first}' removed.")
        } else {
            println("Invalid index.")
        }
    }
}