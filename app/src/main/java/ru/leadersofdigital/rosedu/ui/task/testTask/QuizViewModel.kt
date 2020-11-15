package ru.leadersofdigital.rosedu.ui.task.testTask

import androidx.lifecycle.MutableLiveData
import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.models.MainTaskRepository
import ru.leadersofdigital.rosedu.models.model.Quiz
import ru.leadersofdigital.rosedu.ui.task.testTask.state.QuizState

class QuizViewModel(private val mainTaskRepository: MainTaskRepository) : BaseViewModel<QuizState>(QuizState("", listOf(),"")) {

    val shot: MutableLiveData<String> = MutableLiveData<String>()

    init {
        updateState(
            currentState.copy(
                title = "",
                listTests = mainTaskRepository.getQuizList(),
                ""
            )
        )
    }

    fun finishQuiz() {
        val countMax = currentState.listTests.size
        var countValid = 0
        currentState.listTests.forEach {
            if(it.isValid()) {
                countValid++
            }
        }
        shot.value = "$countValid/$countMax"
        mainTaskRepository.updateQuizAnswers(currentState.listTests)

        val result = mainTaskRepository.validateAll().toString()
        updateState(currentState.copy(result = result))
    }

    fun handleClickGroup(item: Quiz) {
        when(item){
            is Quiz.QuizAnswer -> {
                val items = currentState.listTests
                    items.forEach {
                    if(it is Quiz.SingleAnswerQuiz)
                        it.answers.forEach {answer->
                            if(answer.id == item.id){
                                it.answers.forEach { it.isSelected = false }
                                answer.isSelected = !answer.isSelected
                            }
                        }
                }
                updateState(currentState.copy(listTests = items, result = ""))
            }
        }
    }
}