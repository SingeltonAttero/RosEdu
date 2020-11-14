package ru.leadersofdigital.rosedu.ui.auth.dialog

import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.core.ResourceManager
import ru.leadersofdigital.rosedu.ui.auth.dialog.state.HelpDialogState

class HelpViewModel(resourceManager: ResourceManager) : BaseViewModel<HelpDialogState>(HelpDialogState("", "")) {

    init {
        updateState(
            currentState.copy(
                title = resourceManager.getString(R.string.help_title),
                descriptionHelps = resourceManager.getString(R.string.help_description)
            )
        )
    }
}