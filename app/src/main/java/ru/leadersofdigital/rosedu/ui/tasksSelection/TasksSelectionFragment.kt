package ru.leadersofdigital.rosedu.ui.tasksSelection

import kotlinx.android.synthetic.main.fragment_tasks_selection.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseFragment
import ru.leadersofdigital.rosedu.ui.Screens
import ru.leadersofdigital.rosedu.ui.tasksSelection.state.TasksSelectionState
import ru.terrakok.cicerone.Router

class TasksSelectionFragment : BaseFragment<TasksSelectionState, TasksSelectionViewModel>(R.layout.fragment_tasks_selection) {

    private val router by inject<Router>()

    companion object{
        fun newInstance() = TasksSelectionFragment()
    }

    override val viewModel: TasksSelectionViewModel by viewModel()

    override fun renderState(state: TasksSelectionState) {
        buttonNext.setOnClickListener { router.navigateTo(Screens.TaskFlowScreen) }
    }

    override fun onBackPressed() {
        router.exit()
    }
}