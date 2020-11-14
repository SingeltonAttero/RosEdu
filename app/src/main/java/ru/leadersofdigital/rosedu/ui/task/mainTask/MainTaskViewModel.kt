package ru.leadersofdigital.rosedu.ui.task.mainTask

import ru.leadersofdigital.rosedu.core.BaseViewModel
import ru.leadersofdigital.rosedu.models.DataSourceDevice
import ru.leadersofdigital.rosedu.models.model.TypeDevice
import ru.leadersofdigital.rosedu.ui.task.mainTask.state.MainTaskState
import ru.leadersofdigital.rosedu.ui.task.mainTask.state.SceneState

class MainTaskViewModel : BaseViewModel<MainTaskState>(MainTaskState(listOf())) {

    companion object {
        private const val MAX_WIDTH = 480
        private const val MAX_HEIGHT = 400
    }

    fun handleDragParticle(stringId: String, x: Int, y: Int) {
        val originId = stringId.toInt()
        val subDevice = DataSourceDevice.deviceLIst.map { it.listSubDevice }.flatten().first { originId == it.id }
        val scale = if (subDevice.type == TypeDevice.INDUSTRIAL_SWITCHES) 1.5F else 1F
        if (currentState.itemScenes.map { it.subDevice.id }.contains(originId)) {
            val newItems = currentState.itemScenes.map {
                if (it.subDevice.id == originId) it.copy(
                    width = (MAX_WIDTH * scale).toInt(),
                    height = (MAX_HEIGHT * scale).toInt(),
                    positionX = x - (MAX_WIDTH / 2),
                    positionY = y - (MAX_HEIGHT / 2)
                ) else it
            }
            updateState(
                currentState.copy(itemScenes = newItems)
            )
        } else {
            val toMutableList = currentState.itemScenes.toMutableList()
            toMutableList.add(
                SceneState(
                    subDevice = subDevice,
                    width = (MAX_WIDTH * scale).toInt(),
                    height = (MAX_HEIGHT * scale).toInt(),
                    positionX = x - ((MAX_WIDTH * scale).toInt() / 2),
                    positionY = y - ((MAX_HEIGHT * scale).toInt() / 2)
                )
            )
            updateState(
                currentState.copy(
                    itemScenes = toMutableList
                )
            )
        }

    }

    fun handleDeleteScene(id: Int) {
        updateState(
            currentState.copy(
                itemScenes = currentState.itemScenes.filter { it.subDevice.id != id }
            )
        )
    }
}