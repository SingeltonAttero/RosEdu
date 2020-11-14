package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogGooseSettings

import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.models.MainTaskRepository
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogGooseSettings.state.GooseSettingsState

class GooseSettingsViewModel(
    private val mainTaskRepository: MainTaskRepository
) : BaseViewModel<GooseSettingsState>(GooseSettingsState()) {

    init {
        updateState(GooseSettingsState(mainTaskRepository.gooseConnections))
    }

    fun updateConnections(
        enter1Connections1: List<Boolean>,
        enter1Connections2: List<Boolean>,
        enter1Connections3: List<Boolean>,
        enter2Connections1: List<Boolean>,
        enter2Connections2: List<Boolean>,
        enter2Connections3: List<Boolean>
    ) {
        mainTaskRepository.gooseConnections.ied1Enter1.forEachIndexed { index, _ ->
            mainTaskRepository.gooseConnections.ied1Enter1[index] = enter1Connections1[index]
        }
        mainTaskRepository.gooseConnections.ied1Enter2.forEachIndexed { index, _ ->
            mainTaskRepository.gooseConnections.ied1Enter2[index] = enter1Connections2[index]
        }
        mainTaskRepository.gooseConnections.ied1Enter3.forEachIndexed { index, _ ->
            mainTaskRepository.gooseConnections.ied1Enter3[index] = enter1Connections3[index]
        }

        mainTaskRepository.gooseConnections.ied2Enter1.forEachIndexed { index, _ ->
            mainTaskRepository.gooseConnections.ied2Enter1[index] = enter2Connections1[index]
        }
        mainTaskRepository.gooseConnections.ied2Enter2.forEachIndexed { index, _ ->
            mainTaskRepository.gooseConnections.ied2Enter2[index] = enter2Connections2[index]
        }
        mainTaskRepository.gooseConnections.ied2Enter3.forEachIndexed { index, _ ->
            mainTaskRepository.gooseConnections.ied2Enter3[index] = enter2Connections3[index]
        }
    }
}