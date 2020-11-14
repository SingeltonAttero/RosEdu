package ru.leadersofdigital.rosedu.ui.task.testTask

import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseFragment
import ru.leadersofdigital.rosedu.di.Qualifiers
import ru.leadersofdigital.rosedu.ui.task.testTask.state.TestTaskState
import ru.terrakok.cicerone.Router

class TestTaskFragment : BaseFragment<TestTaskState,TestTaskViewModel>(R.layout.fragment_test_task) {

    companion object{
        fun newInstance() = TestTaskFragment()
    }

    private val router get() = getKoin()
        .getOrCreateScope(Qualifiers.TASK_ROUTER_ID, Qualifiers.TASK_FLOW_SESSION)
        .get<Router>()

    override val viewModel: TestTaskViewModel by viewModel()

    override fun renderState(state: TestTaskState) {
    }

    override fun onBackPressed() {
        router.exit()
    }
}