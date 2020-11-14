package ru.leadersofdigital.rosedu.models.model

sealed class Quiz(
    val id: String
) {
    open fun isValid(): Boolean {
        return true
    }

    data class SingleAnswerQuiz(
        val questionId: Int,
        val question: String,
        val answers: List<QuizAnswer>,
        val goodAnswerId: Int
    ) : Quiz(question) {

        override fun isValid() = goodAnswerId == answers.firstOrNull { it.isSelected }?.answerId
    }

    data class QuizAnswer(
        val title: String,
        val answerId: Int
    ) :Quiz(title) {
        var isSelected: Boolean = false
    }

}