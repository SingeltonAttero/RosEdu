package ru.leadersofdigital.rosedu.ui.main

import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.core.ResourceManager
import ru.leadersofdigital.rosedu.ui.main.state.MainState

class MainViewModel(private val resourceManager: ResourceManager) : BaseViewModel<MainState>(MainState("")) {

    init {
        updateState(
            state = currentState.copy(
                testText = resourceManager.getString(R.string.app_name)
            )
        )
    }
}