# Overview

As a software engineer, I want to build practical tools while learning new languages, and Kotlin is a modern language used for everything from backend services to Android apps. This project helps me practice the core ideas of Kotlin in a small program that solves a real problem.

FlightChecklistManager is a console application written in Kotlin. A user can create checklists for a flight, such as pre-departure or turnaround, add tasks with a priority, mark tasks as done, remove tasks, and see a progress percentage. Several checklists can be kept at the same time, and the user can switch between them.

My purpose in writing this software was to learn Kotlin syntax by using it in a realistic program. The program uses mutable and immutable variables, expressions, conditionals, loops, functions, and classes. It also uses a data class, collections (a mutable list and a map), and the `when` keyword in several ways.

[Software Demo Video](http://youtube.link.goes.here)

# Development Environment

I used IntelliJ IDEA to write and run the program, Git to track the code, and GitHub to publish it. The program runs on OpenJDK 27.

The program is written in Kotlin and uses only the Kotlin standard library.

# Useful Websites

- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Kotlin Data Classes](https://kotlinlang.org/docs/data-classes.html)
- [Kotlin Collections Overview](https://kotlinlang.org/docs/collections-overview.html)
- [Kotlin Control Flow (when, if, loops)](https://kotlinlang.org/docs/control-flow.html)
- [Wikipedia: Kotlin](https://en.wikipedia.org/wiki/Kotlin_(programming_language))

# Future Work

- Save checklists to a file so they are not lost when the program closes.
- Use an enum for task priority instead of text.
- Add a command to edit the description of an existing task.
- Build an Android app version of the checklist manager.