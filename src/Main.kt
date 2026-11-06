// FlightChecklistManager
// A console app to manage flight checklists (for example pre-departure or turnaround).

// Print a prompt, then read one line of text typed by the user
fun ask(prompt: String): String {
    print(prompt)
    return (readlnOrNull() ?: "").trim()
}

// Show the menu and the name of the checklist that is currently selected
fun printMenu(currentName: String) {
    println()
    println("=== Flight Checklist Manager ===")
    println("Current checklist: $currentName")
    println("1. Create a new checklist")
    println("2. Add a task")
    println("3. Mark a task as done")
    println("4. Remove a task")
    println("5. Show the checklist")
    println("6. Switch to another checklist")
    println("0. Quit")
}

fun main() {
    // A Map of checklists by name, so I can keep more than one
    val checklists = mutableMapOf<String, Checklist>()
    var current: Checklist? = null
    var running = true

    // Keep showing the menu until the user chooses Quit
    while (running) {
        val active = current
        printMenu(active?.name ?: "none")
        val choice = ask("Choose an option: ")

        // Options 2 to 5 only make sense when a checklist is selected
        if (choice in listOf("2", "3", "4", "5") && active == null) {
            println("Create or switch to a checklist first (option 1 or 6).")
            continue
        }

        when (choice) {
            "1" -> {
                val name = ask("Name of the new checklist: ")
                if (name.isEmpty()) {
                    println("The name cannot be empty.")
                } else {
                    val newList = Checklist(name)
                    checklists[name] = newList
                    current = newList
                    println("Created and selected \"$name\".")
                }
            }
            "2" -> {
                val description = ask("Task description: ")
                if (description.isEmpty()) {
                    println("The description cannot be empty.")
                } else {
                    val p = ask("Priority (high, normal, low) [normal]: ").lowercase()
                    val priority = if (p == "high" || p == "low") p else "normal"
                    active?.addTask(description, priority)
                    println("Task added.")
                }
            }
            "3" -> {
                val number = ask("Number of the task to mark as done: ").toIntOrNull()
                if (number == null) {
                    println("Please enter a number.")
                } else if (active?.completeTask(number) == true) {
                    println("Task marked as done.")
                } else {
                    println("There is no task with that number.")
                }
            }
            "4" -> {
                val number = ask("Number of the task to remove: ").toIntOrNull()
                if (number == null) {
                    println("Please enter a number.")
                } else if (active?.removeTask(number) == true) {
                    println("Task removed.")
                } else {
                    println("There is no task with that number.")
                }
            }
            "5" -> active?.display()
            "6" -> {
                println("Checklists: ${checklists.keys.joinToString(", ")}")
                val name = ask("Name of the checklist to switch to: ")
                val found = checklists[name]
                if (found == null) {
                    println("There is no checklist with that name.")
                } else {
                    current = found
                    println("Switched to \"$name\".")
                }
            }
            "0" -> running = false
            else -> println("That is not a valid option.")
        }
    }
    println("Goodbye!")
}
