// A checklist has a name and a list of tasks.
// It can add, remove and complete tasks, and show progress.
class Checklist(val name: String) {

    // MutableList lets us add and remove tasks as the user works
    private val tasks = mutableListOf<Task>()

    // Add a new task to the end of the list
    fun addTask(description: String, priority: String = "normal") {
        tasks.add(Task(description, false, priority))
    }

    // Remove a task by its number (1, 2, 3...). Returns false if the number is invalid.
    fun removeTask(number: Int): Boolean {
        if (number < 1 || number > tasks.size) {
            return false
        }
        tasks.removeAt(number - 1)
        return true
    }

    // Mark a task as done by its number. Returns false if the number is invalid.
    fun completeTask(number: Int): Boolean {
        if (number < 1 || number > tasks.size) {
            return false
        }
        tasks[number - 1].isDone = true
        return true
    }

    // Calculate the percentage of tasks that are done
    fun progressPercent(): Int {
        if (tasks.isEmpty()) {
            return 0
        }
        val doneCount = tasks.count { it.isDone }
        return doneCount * 100 / tasks.size
    }

    // Print every task with its number, status and priority
    fun display() {
        println("--- $name ---")
        if (tasks.isEmpty()) {
            println("No tasks yet.")
            return
        }
        for ((index, task) in tasks.withIndex()) {
            val mark = if (task.isDone) "[x]" else "[ ]"
            // when picks a label based on the priority text
            val label = when (task.priority) {
                "high" -> "HIGH"
                "low" -> "low"
                else -> "normal"
            }
            println("${index + 1}. $mark ${task.description} ($label)")
        }
        println("Progress: ${progressPercent()}%")
    }
}