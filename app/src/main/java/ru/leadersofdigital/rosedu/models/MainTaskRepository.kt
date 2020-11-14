package ru.leadersofdigital.rosedu.models

import ru.leadersofdigital.rosedu.models.model.GooseConnections
import ru.leadersofdigital.rosedu.models.model.Quiz
import ru.leadersofdigital.rosedu.models.model.SubDevice

class MainTaskRepository {
    private val deviceList: MutableList<SubDevice> = mutableListOf()

    val gooseConnections = GooseConnections()
    private var quizList: MutableList<Quiz> = DataSourceQuiz.quizList.toMutableList()

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

    fun getQuizList():List<Quiz> = quizList

    fun updateQuizAnswers(items: List<Quiz>) {
        quizList = items.toMutableList()
    }
}