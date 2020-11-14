package ru.leadersofdigital.rosedu.models

import ru.leadersofdigital.rosedu.models.model.Device
import ru.leadersofdigital.rosedu.models.model.SubDevice
import ru.leadersofdigital.rosedu.models.model.TypeDevice

object DataSourceDevice {
    val deviceLIst = listOf(
        Device(
            1, "РЗА", listOf(
                SubDevice(11, "IED 1"),
                SubDevice(12, "IED 2"),
                SubDevice(13, "IED 3"),
                SubDevice(14, "IED 4"),
                SubDevice(15, "IED 5"),
            ), TypeDevice.RZA
        ),
        Device(
            2, "Промышленные коммутаторы", listOf(
                SubDevice(21, "Коммутаторы 1"),
                SubDevice(22, "Коммутаторы 2"),
                SubDevice(23, "Коммутаторы 3"),
            ), TypeDevice.INDUSTRIAL_SWITCHES
        ),
        Device(
            3, "Подключения", listOf(
                SubDevice(31, "Витая пара"),
                SubDevice(32, "оптоволоконного кабель{одномод.}"),
                SubDevice(31, "оптоволоконного кабель {многомод}"),
            ), TypeDevice.CONNECTION
        )
    )
}