package ru.leadersofdigital.rosedu.ui.task.testTask.state

import ru.leadersofdigital.rosedu.models.model.Quiz

data class QuizState(
    val title: String,
    val listTests: List<Quiz>
)