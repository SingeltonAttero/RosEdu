package ru.leadersofdigital.rosedu.ui.task.mainTask

import kotlinx.android.synthetic.main.fragment_main_task.*
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseFragment
import ru.leadersofdigital.rosedu.di.Qualifiers
import ru.leadersofdigital.rosedu.ui.Screens
import ru.leadersofdigital.rosedu.ui.task.mainTask.state.MainTaskState
import ru.terrakok.cicerone.Router

class MainTaskFragment : BaseFragment<MainTaskState, MainTaskViewModel>(R.layout.fragment_main_task) {

    private val router get() = getKoin()
        .getOrCreateScope(Qualifiers.TASK_ROUTER_ID, Qualifiers.TASK_FLOW_SESSION)
        .get<Router>()

    companion object{
        fun newInstance() = MainTaskFragment()
    }

    override val viewModel: MainTaskViewModel by viewModel()

    override fun renderState(state: MainTaskState) {
        mainTaskContainer.setOnClickListener { router.navigateTo(Screens.TestTaskScreen) }
    }

    override fun onBackPressed() {
        router.exit()
    }
}