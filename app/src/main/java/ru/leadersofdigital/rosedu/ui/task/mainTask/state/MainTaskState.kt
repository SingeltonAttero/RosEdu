package ru.leadersofdigital.rosedu.ui.task.mainTask.state

import ru.leadersofdigital.rosedu.models.model.SubDevice
import ru.leadersofdigital.rosedu.models.model.TypeConnection

data class MainTaskState(
    val itemScenes: List<SceneState>,
)

data class SceneState(
    val subDevice: SubDevice,
    val width: Int,
    val height: Int,
    val positionX: Int,
    val positionY: Int,
    val isSelected: Boolean = false,
    val isOpenConnect: Boolean = false,
    val typeConnection: TypeConnection = TypeConnection.TWISTED_PAIR
)