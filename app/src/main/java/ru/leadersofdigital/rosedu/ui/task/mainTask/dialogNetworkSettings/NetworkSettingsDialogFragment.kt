package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings

import kotlinx.android.synthetic.main.dialog_main_task_network_settings.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.core.BaseDialogFragment
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings.state.NetworkSettingsState
import ru.leadersofdigital.rosedu.R

class NetworkSettingsDialogFragment : BaseDialogFragment<NetworkSettingsState, NetworkSettingsViewModel>() {

    override val viewModel: NetworkSettingsViewModel by viewModel()

    override val layoutRes: Int = R.layout.dialog_main_task_network_settings

    companion object {
        fun newInstance() = NetworkSettingsDialogFragment()
    }

    override fun renderState(state: NetworkSettingsState) {
        textViewDeviceTitle.text = state.deviceTitle
        textViewDeviceType.text = state.deviceType
    }
}