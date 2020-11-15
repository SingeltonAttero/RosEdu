package ru.leadersofdigital.rosedu.models

import ru.leadersofdigital.rosedu.core.validator.Validator
import ru.leadersofdigital.rosedu.models.model.*

class MainTaskRepository {
    private val deviceList: MutableList<SubDevice> = mutableListOf()

    val gooseConnections = GooseConnections()
    private var quizList: MutableList<Quiz> = DataSourceQuiz.quizList.toMutableList()
    var typeConnection = TypeConnection.TWISTED_PAIR

    private var selectedDeviceId: Int? = null

    fun getSelectedDevice() = deviceList.firstOrNull { it.id == selectedDeviceId }

    fun getIedDevices() = deviceList.filter { it.type == TypeDevice.RZA }

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

    fun getQuizList(): List<Quiz> = quizList

    fun updateQuizAnswers(items: List<Quiz>) {
        quizList = items.toMutableList()
    }

    fun validateAll() =
        Validator.validateAll(deviceList, gooseConnections, quizList)

}