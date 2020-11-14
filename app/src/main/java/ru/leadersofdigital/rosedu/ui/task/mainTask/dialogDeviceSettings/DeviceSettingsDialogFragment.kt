package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogDeviceSettings

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.dialog_main_task_device_settings.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.core.BaseDialogFragment
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogDeviceSettings.state.DeviceSettingsState

class DeviceSettingsDialogFragment :
    BaseDialogFragment<DeviceSettingsState, DeviceSettingsViewModel>() {

    override val viewModel: DeviceSettingsViewModel by viewModel()

    override val styleRes: Int = R.style.AlmostFullScreenDialog
    override val layoutRes: Int = R.layout.dialog_main_task_device_settings

    companion object {
        fun newInstance() = DeviceSettingsDialogFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonApply.setOnClickListener {
            viewModel.onButtonSaveClick(
                editTextGcb.text.toString(),
                editTextMacAddress.text.toString(),
                editTextMaxTime.text.toString(),
                editTextMinTime.text.toString(),
                editTextGooseId.text.toString(),
                editTextAppId.text.toString(),
                editTextVlanId.text.toString(),
            )
            dismiss()
        }

        buttonGcbDesc.setOnClickListener { showDescriptionAlert(R.string.device_settings_gcb_name, R.string.gcb_description) }
        buttonMacAddressDesc.setOnClickListener { showDescriptionAlert(R.string.device_settings_mac_address, R.string.mac_address_description) }
        buttonMaxTimeDesc.setOnClickListener { showDescriptionAlert(R.string.device_settings_max_time, R.string.max_time_description) }
        buttonMinTimeDesc.setOnClickListener { showDescriptionAlert(R.string.device_settings_min_time, R.string.min_time_description) }
        buttonGooseIdDesc.setOnClickListener { showDescriptionAlert(R.string.device_settings_goose_id, R.string.gooseId_description) }
        buttonAppIdDesc.setOnClickListener { showDescriptionAlert(R.string.device_settings_app_id, R.string.appId_description) }
        buttonVlanIdDesc.setOnClickListener { showDescriptionAlert(R.string.device_settings_vlan_id, R.string.vlanId_description) }
    }



    override fun renderState(state: DeviceSettingsState) {
        state.device?.let {
            textViewDeviceTitle.text = resources.getString(R.string.device_title,it.name)
            textViewDeviceType.text = resources.getString(R.string.device_type,it.type.name)
            editTextGcb.setText(it.gcbName)
            editTextMacAddress.setText(it.macAddress)
            editTextMaxTime.setText(it.maxTime)
            editTextMinTime.setText(it.minTime)
            editTextGooseId.setText(it.gooseId)
            editTextAppId.setText(it.appId)
            editTextVlanId.setText(it.vlanId)
        }

    }

}