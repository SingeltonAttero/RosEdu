package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogDeviceSettings

import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.core.ResourceManager
import ru.leadersofdigital.rosedu.models.MainTaskRepository
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogDeviceSettings.state.DeviceSettingsState

class DeviceSettingsViewModel(
    resourceManager: ResourceManager,
    private val mainTaskRepository: MainTaskRepository
) : BaseViewModel<DeviceSettingsState>(
    DeviceSettingsState(null)
) {
    init {
        mainTaskRepository.getSelectedDevice()?.let {
            updateState(
                DeviceSettingsState(it)
            )
        }
    }

    fun onButtonSaveClick(gcbName: String, macAddress: String, maxTime: String, minTime: String, gooseId: String, appId: String, vlanId: String) {
        mainTaskRepository.getSelectedDevice()?.let {
            mainTaskRepository.updateDevice(it.copy(macAddress = macAddress, gcbName = gcbName, maxTime = maxTime, minTime = minTime, gooseId = gooseId, appId = appId, vlanId = vlanId))
        }
    }
}