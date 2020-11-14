package ru.leadersofdigital.rosedu.ui.task.testTask

import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_test_task.*
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseFragment
import ru.leadersofdigital.rosedu.core.adapter.QuizAdapterDelegate
import ru.leadersofdigital.rosedu.di.Qualifiers
import ru.leadersofdigital.rosedu.models.model.Quiz
import ru.leadersofdigital.rosedu.ui.task.testTask.state.QuizState
import ru.terrakok.cicerone.Router

class QuizFragment : BaseFragment<QuizState, QuizViewModel>(R.layout.fragment_test_task) {

    companion object {
        fun newInstance() = QuizFragment()
    }

    private val router
        get() = getKoin()
            .getOrCreateScope(Qualifiers.TASK_ROUTER_ID, Qualifiers.TASK_FLOW_SESSION)
            .get<Router>()

    private val adapter by lazy {
        QuizAdapterDelegate(viewModel::handleClickGroup).createDelegate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        viewModel.shot.observe(
            requireActivity(), {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        )
        buttonFinish.setOnClickListener {
            viewModel.finishQuiz()
            onBackPressed()
        }
    }

    override val viewModel: QuizViewModel by viewModel()

    override fun renderState(state: QuizState) {
        val items = mutableListOf<Quiz>()
        state.listTests.forEach {
            items.add(it)
            if (it is Quiz.SingleAnswerQuiz) {
                it.answers.forEach { answer -> items.add(answer) }
            }
        }
        adapter.items = items
        adapter.notifyDataSetChanged()
    }

    override fun onBackPressed() {
        router.exit()
    }
}