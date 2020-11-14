package ru.leadersofdigital.rosedu.models

import ru.leadersofdigital.rosedu.models.model.Device
import ru.leadersofdigital.rosedu.models.model.SubDevice
import ru.leadersofdigital.rosedu.models.model.TypeDevice

object DataSourceDevice {
    val deviceLIst = listOf(
        Device(
            1, "РЗА", listOf(
                SubDevice(11, "IED 1", TypeDevice.RZA),
                SubDevice(12, "IED 2", TypeDevice.RZA),
                SubDevice(13, "IED 3", TypeDevice.RZA),
                SubDevice(14, "IED 4", TypeDevice.RZA),
                SubDevice(15, "IED 5", TypeDevice.RZA),
            ), TypeDevice.RZA
        ),
        Device(
            2, "Промышленные коммутаторы", listOf(
                SubDevice(21, "Коммутаторы 1", TypeDevice.INDUSTRIAL_SWITCHES),
                SubDevice(22, "Коммутаторы 2", TypeDevice.INDUSTRIAL_SWITCHES),
                SubDevice(23, "Коммутаторы 3", TypeDevice.INDUSTRIAL_SWITCHES),
            ), TypeDevice.INDUSTRIAL_SWITCHES
        ),
        Device(
            3, "Подключения", listOf(
                SubDevice(31, "Витая пара", TypeDevice.CONNECTION),
                SubDevice(32, "оптоволоконного кабель{одномод.}", TypeDevice.CONNECTION),
                SubDevice(31, "оптоволоконного кабель {многомод}", TypeDevice.CONNECTION),
            ), TypeDevice.CONNECTION
        )
    )
}