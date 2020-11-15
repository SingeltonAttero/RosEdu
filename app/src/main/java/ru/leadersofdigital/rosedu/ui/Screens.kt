package ru.leadersofdigital.rosedu.ui

import androidx.fragment.app.Fragment
import ru.leadersofdigital.rosedu.ui.auth.AuthFragment
import ru.leadersofdigital.rosedu.ui.task.TaskFlowFragment
import ru.leadersofdigital.rosedu.ui.task.mainTask.MainTaskFragment
import ru.leadersofdigital.rosedu.ui.task.testTask.QuizFragment
import ru.leadersofdigital.rosedu.ui.tasksSelection.TasksSelectionFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object AuthScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return AuthFragment.newInstance()
        }
    }

    object TasksSelectionScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = TasksSelectionFragment.newInstance()
    }

    object MainTaskScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = MainTaskFragment.newInstance()
    }

    object QuizScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = QuizFragment.newInstance()
    }

    object TaskFlowScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = TaskFlowFragment.newInstance()
    }
}