package ru.leadersofdigital.rosedu.ui.device

import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.core.ResourceManager
import ru.leadersofdigital.rosedu.core.adapter.DeviceItemState
import ru.leadersofdigital.rosedu.models.DataSourceDevice
import ru.leadersofdigital.rosedu.models.MainTaskRepository
import ru.leadersofdigital.rosedu.models.model.Device
import ru.leadersofdigital.rosedu.models.model.TypeDevice
import ru.leadersofdigital.rosedu.ui.device.state.DeviceState

class DeviceViewModel(resourceManager: ResourceManager, private val repository: MainTaskRepository) :
    BaseViewModel<DeviceState>(DeviceState("", listOf())) {

    init {
        updateState(
            currentState.copy(
                title = resourceManager.getString(R.string.select_device_title),
                listDevice = mapToState(DataSourceDevice.deviceLIst)
            )
        )
    }

    fun handleClickGroup(itemState: DeviceItemState) {
        when (itemState) {
            is DeviceItemState.Group -> {
                val device = DataSourceDevice.deviceLIst.first { itemState.id == it.id }
                val subDeviceList = device.listSubDevice
                val indexElementDevice = currentState.listDevice.indexOf(itemState)

                if (!itemState.isOpenGroup) {
                    val items = currentState.listDevice.toMutableList()
                    val addItems =
                        subDeviceList.mapIndexed { index, deviceScenes ->
                            val isSelected = deviceScenes.type == TypeDevice.CONNECTION && index == 0
                            DeviceItemState.Device(
                                deviceScenes.id,
                                deviceScenes.name,
                                deviceScenes.type,
                                itemState.icon,
                                isSelected,
                                deviceScenes.typeConnection
                            )
                        }
                    items.removeAt(indexElementDevice)
                    items.addAll(indexElementDevice, addItems)

                    items.add(indexElementDevice, itemState.copy(isOpenGroup = !itemState.isOpenGroup))
                    updateState(
                        currentState.copy(
                            listDevice = items
                        )
                    )
                } else {
                    val items =
                        currentState.listDevice.map {
                            if (it.id == itemState.id && it is DeviceItemState.Group)
                                it.copy(
                                    isOpenGroup = !it.isOpenGroup
                                ) else it
                        }.filter { deviceItemState -> !(subDeviceList.map { it.id }.contains(deviceItemState.id)) }
                            .toMutableList()
                    updateState(
                        currentState.copy(
                            listDevice = items
                        )
                    )
                }
            }
            is DeviceItemState.Device -> {
                updateState(
                    currentState.copy(
                        listDevice = currentState.listDevice.map { deviceItemState ->
                            if (deviceItemState.id == itemState.id && deviceItemState is DeviceItemState.Device && deviceItemState.type == TypeDevice.CONNECTION) {
                                repository.typeConnection = deviceItemState.typeConnection
                                deviceItemState.copy(
                                    isSelect = true
                                )
                            } else if (deviceItemState is DeviceItemState.Device && deviceItemState.type == TypeDevice.CONNECTION) {
                                deviceItemState.copy(isSelect = false)
                            } else deviceItemState
                        }
                    )
                )
            }
        }
    }

    private fun mapToState(deviceLIst: List<Device>): List<DeviceItemState> {
        return deviceLIst.map {
            val iconGroup = when (it.type) {
                TypeDevice.CONNECTION -> R.drawable.ic_connection_device
                TypeDevice.RZA -> R.drawable.ic_relay_group_rsa
                TypeDevice.INDUSTRIAL_SWITCHES -> R.drawable.ic_switcher_device
            }
            DeviceItemState.Group(it.id, it.name, iconGroup)
        }
    }

}