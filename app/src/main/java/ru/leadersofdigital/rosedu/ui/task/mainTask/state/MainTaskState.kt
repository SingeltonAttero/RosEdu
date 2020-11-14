package ru.leadersofdigital.rosedu.ui.task.mainTask.state

import ru.leadersofdigital.rosedu.models.model.SubDevice

data class MainTaskState(
    val itemScenes: List<SceneState>,
)

data class SceneState(
    val subDevice: SubDevice,
    val width: Int,
    val height: Int,
    val positionX: Int,
    val positionY: Int,
    val isSelected: Boolean = false
)