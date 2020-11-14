package ru.leadersofdigital.rosedu.ui.auth.dialog

import kotlinx.android.synthetic.main.dialog_help_auth.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseDialogFragment
import ru.leadersofdigital.rosedu.ui.auth.dialog.state.HelpDialogState

class HelpDialogFragment : BaseDialogFragment<HelpDialogState, HelpViewModel>() {

    companion object {
        fun newInstance() = HelpDialogFragment()
    }

    override val viewModel: HelpViewModel by viewModel()
    override val layoutRes: Int
        get() = R.layout.dialog_help_auth

    override fun renderState(state: HelpDialogState) {
        tvTitle.text = state.title
        tvDescriptionHelp.text = state.descriptionHelps
    }
}