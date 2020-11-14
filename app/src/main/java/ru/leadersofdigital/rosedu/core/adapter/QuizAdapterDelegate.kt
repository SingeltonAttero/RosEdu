package ru.leadersofdigital.rosedu.core.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import kotlinx.android.synthetic.main.item_test_question.*
import kotlinx.android.synthetic.main.item_test_single_answer.*
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.models.model.Quiz
import ru.leadersofdigital.rosedu.models.model.Quiz.QuizAnswer
import ru.leadersofdigital.rosedu.models.model.Quiz.SingleAnswerQuiz

class QuizAdapterDelegate(private val click:(item:Quiz) -> Unit = {}) {

    fun createDelegate() = AsyncListDifferDelegationAdapter(
        DiffTest,
        AdapterDelegatesManager(
            createQuestion(click),
            createAnswer(click)
        )
    )

    private fun createQuestion(click: (item: Quiz) -> Unit) =
        adapterDelegateLayoutContainer<SingleAnswerQuiz, Quiz>(R.layout.item_test_question) {
            bind {
                textViewQuestion.text = "${item.questionId}. ${item.question}"
            }
        }

    private fun createAnswer(click: (item: Quiz) -> Unit) =
        adapterDelegateLayoutContainer<QuizAnswer, Quiz>(R.layout.item_test_single_answer) {
            itemView.setOnClickListener { click.invoke(item) }
            bind {
                radioButtonAnswer.isChecked = item.isSelected
                radioButtonAnswer.text = item.title
            }
        }

    object DiffTest : DiffUtil.ItemCallback<Quiz>() {
        override fun areItemsTheSame(oldItem: Quiz, newItem: Quiz): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Quiz, newItem: Quiz): Boolean = oldItem == newItem

    }
}