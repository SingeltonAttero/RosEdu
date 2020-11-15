package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings

import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.core.ResourceManager
import ru.leadersofdigital.rosedu.models.MainTaskRepository
import ru.leadersofdigital.rosedu.models.model.Device
import ru.leadersofdigital.rosedu.models.model.SubDevice
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings.state.NetworkSettingsState

class NetworkSettingsViewModel(resourceManager: ResourceManager, private val mainTaskRepository: MainTaskRepository) :
    BaseViewModel<NetworkSettingsState>(NetworkSettingsState.initial()) {
    private val iedDevices: List<SubDevice> = mainTaskRepository.getIedDevices()

    init {
        mainTaskRepository.getSelectedDevice()?.let {
            updateState(
                NetworkSettingsState(it, iedDevices)
            )
        }
    }

    fun onButtonSaveClick(ipAddress1: String, mask1:String,ipAddress2: String, mask2:String) {
        mainTaskRepository.getSelectedDevice()?.let {
            mainTaskRepository.updateDevice(it.copy(ipAddress1 = ipAddress1, networkMask1 = mask1,ipAddress2 = ipAddress2, networkMask2 = mask2))
        }
    }
}