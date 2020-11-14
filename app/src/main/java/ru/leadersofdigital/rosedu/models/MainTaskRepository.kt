package ru.leadersofdigital.rosedu.models

import ru.leadersofdigital.rosedu.models.model.SubDevice

class MainTaskRepository {
    private val deviceList: MutableList<SubDevice> = mutableListOf()

    private var selectedDeviceId: Int? = null

    fun getSelectedDevice() = deviceList.firstOrNull { it.id == selectedDeviceId }

    fun setSelectedDevice(id: Int) {
        selectedDeviceId = deviceList.firstOrNull { it.id == id }?.id
    }

    fun updateDevice(device: SubDevice) {
        deviceList[deviceList.indexOfFirst { it.id == selectedDeviceId }] = device
    }

    fun addDevice(device: SubDevice) = deviceList.add(device)

    fun deleteDevice(id: Int) {
        if (selectedDeviceId == id) selectedDeviceId = null
        deviceList.remove(deviceList.firstOrNull { it.id == id })
    }
}