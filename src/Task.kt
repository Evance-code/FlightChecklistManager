// A single item on a flight checklist.
// A data class automatically gives us toString(), equals(), and copy().
data class Task(
    val description: String,       // what needs to be done
    var isDone: Boolean = false,   // starts as not done
    val priority: String = "normal" // "high", "normal", or "low"
)