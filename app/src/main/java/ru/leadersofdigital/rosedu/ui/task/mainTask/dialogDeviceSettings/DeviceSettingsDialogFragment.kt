package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogDeviceSettings

import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.core.BaseDialogFragment
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogDeviceSettings.state.DeviceSettingsState

class DeviceSettingsDialogFragment : BaseDialogFragment<DeviceSettingsState, DeviceSettingsViewModel>() {

    override val viewModel: DeviceSettingsViewModel by viewModel()

    override val styleRes: Int = R.style.AlmostFullScreenDialog
    override val layoutRes: Int = R.layout.dialog_main_task_device_settings

    companion object {
        fun newInstance() = DeviceSettingsDialogFragment()
    }

    override fun renderState(state: DeviceSettingsState) {
    }

}