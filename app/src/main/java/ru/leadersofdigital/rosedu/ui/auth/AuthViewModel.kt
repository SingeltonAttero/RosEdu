package ru.leadersofdigital.rosedu.ui.auth

import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.core.ResourceManager
import ru.leadersofdigital.rosedu.ui.auth.state.AuthState

class AuthViewModel(private val resourceManager: ResourceManager) : BaseViewModel<AuthState>(AuthState("")) {

    init {
        updateState(
            state = currentState.copy(
                testText = resourceManager.getString(R.string.app_name)
            )
        )
    }
}