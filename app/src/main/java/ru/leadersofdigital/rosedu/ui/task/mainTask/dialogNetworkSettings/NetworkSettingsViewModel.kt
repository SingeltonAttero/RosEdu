package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings

import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.core.ResourceManager
import ru.leadersofdigital.rosedu.models.MainTaskRepository
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogDeviceSettings.state.DeviceSettingsState
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings.state.NetworkSettingsState

class NetworkSettingsViewModel(resourceManager: ResourceManager, private val mainTaskRepository: MainTaskRepository) :
    BaseViewModel<NetworkSettingsState>(NetworkSettingsState.initial()) {
    init {
        mainTaskRepository.getSelectedDevice()?.let {
            updateState(
                NetworkSettingsState(it)
            )
        }
    }

    fun onButtonSaveClick(ipAddress: String, mask:String) {
        mainTaskRepository.getSelectedDevice()?.let {
            mainTaskRepository.updateDevice(it.copy(ipAddress = ipAddress, networkMask = mask))
        }
    }
}