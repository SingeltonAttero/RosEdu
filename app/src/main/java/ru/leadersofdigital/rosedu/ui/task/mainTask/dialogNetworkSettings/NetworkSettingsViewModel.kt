package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings

import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.core.ResourceManager
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings.state.NetworkSettingsState

class NetworkSettingsViewModel(resourceManager: ResourceManager) :
    BaseViewModel<NetworkSettingsState>(NetworkSettingsState.initial()) {
    init {
        updateState(
            NetworkSettingsState(
                resourceManager.getString(R.string.network_settings_device_title, "Test"),
                resourceManager.getString(R.string.network_settings_device_type, "Test type")
        )
        )
    }
}