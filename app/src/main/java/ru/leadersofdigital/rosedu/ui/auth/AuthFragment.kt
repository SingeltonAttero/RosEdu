package ru.leadersofdigital.rosedu.ui.auth

import kotlinx.android.synthetic.main.fragment_auth.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.tvTestText
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseFragment
import ru.leadersofdigital.rosedu.ui.Screens
import ru.leadersofdigital.rosedu.ui.auth.state.AuthState
import ru.terrakok.cicerone.Router

class AuthFragment : BaseFragment<AuthState, AuthViewModel>(R.layout.fragment_auth) {

    private val router by inject<Router>()

    companion object{
        fun newInstance() = AuthFragment()
    }

    override val viewModel: AuthViewModel by viewModel()

    override fun renderState(state: AuthState) {
        tvTestText.text = state.testText
        frameLayoutContent.setOnClickListener { router.navigateTo(Screens.TasksSelectionScreen) }
    }
}
