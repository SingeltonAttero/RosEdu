package ru.leadersofdigital.rosedu.ui.device.state

import ru.leadersofdigital.rosedu.core.adapter.DeviceItemState

data class DeviceState(
    val title: String,
    val listDevice: List<DeviceItemState>
)

