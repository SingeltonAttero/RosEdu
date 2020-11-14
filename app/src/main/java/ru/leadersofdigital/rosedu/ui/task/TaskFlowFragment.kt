package ru.leadersofdigital.rosedu.ui.task

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseFragment
import ru.leadersofdigital.rosedu.di.Qualifiers
import ru.leadersofdigital.rosedu.ui.Screens
import ru.leadersofdigital.rosedu.ui.task.mainTask.MainTaskFragment
import ru.leadersofdigital.rosedu.ui.task.state.TaskFlowState
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class TaskFlowFragment :
    BaseFragment<TaskFlowState, TaskFlowViewModel>(R.layout.flow_fragment_task) {

    companion object {
        fun newInstance() = TaskFlowFragment()
    }

    private val router by inject<Router>()

    private val currentFragment
        get() = childFragmentManager.findFragmentById(R.id.frameLayoutContainer) as? BaseFragment<*, *>


    override val viewModel: TaskFlowViewModel by viewModel()

    override fun renderState(state: TaskFlowState) {
        //nothing to do
    }

    private val childRouter
        get() = getKoin()
            .getOrCreateScope(Qualifiers.TASK_ROUTER_ID, Qualifiers.TASK_FLOW_SESSION)
            .get<Router>()

    private val navigatorHolder
        get() = getKoin()
            .getOrCreateScope(Qualifiers.TASK_NAVIGATOR_HOLDER_ID, Qualifiers.TASK_FLOW_SESSION)
            .get<NavigatorHolder>()

    private val navigator by lazy {
        object : SupportAppNavigator(
            requireActivity(),
            childFragmentManager,
            R.id.frameLayoutContainer
        ) {

            override fun setupFragmentTransaction(
                command: Command,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction
            ) {
                fragmentTransaction.setReorderingAllowed(true)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            childRouter.navigateTo(Screens.MainTaskScreen)
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        if(childFragmentManager.fragments.last() is MainTaskFragment) router.exit() else
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }
}