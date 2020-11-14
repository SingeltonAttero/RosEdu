package ru.leadersofdigital.rosedu.models

import ru.leadersofdigital.rosedu.models.model.Device

class MainTaskRepository {
    private val deviceList: MutableList<Device> = mutableListOf()

    private var selectedDeviceId: Int? = null

    fun getSelectedDevice() = deviceList.firstOrNull { it.id == selectedDeviceId }

    fun setSelectedDevice(id: Int) {
        selectedDeviceId = deviceList.firstOrNull { it.id == id }?.id
    }

    fun updateDevice(device: Device) {
        deviceList[deviceList.indexOfFirst { it.id == selectedDeviceId }] = device
    }

    fun addDevice(device: Device) = deviceList.add(device)

    fun deleteDevice(id: Int) {
        if (selectedDeviceId == id) selectedDeviceId = null
        deviceList.remove(deviceList.firstOrNull { it.id == id })
    }
}