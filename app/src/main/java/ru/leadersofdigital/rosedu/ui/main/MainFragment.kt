package ru.leadersofdigital.rosedu.ui.main

import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseFragment
import ru.leadersofdigital.rosedu.ui.main.state.MainState

class MainFragment : BaseFragment<MainState, MainViewModel>(R.layout.fragment_main) {

    companion object{
        fun newInstance() = MainFragment()
    }

    override val viewModel: MainViewModel by viewModel()

    override fun renderState(state: MainState) {
        tvTestText.text = state.testText
    }
}
