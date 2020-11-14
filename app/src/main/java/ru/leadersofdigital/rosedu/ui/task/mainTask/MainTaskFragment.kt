package ru.leadersofdigital.rosedu.ui.task.mainTask

import android.os.Bundle
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import coil.load
import kotlinx.android.synthetic.main.drop_view_item.view.*
import kotlinx.android.synthetic.main.fragment_main_task.*
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseFragment
import ru.leadersofdigital.rosedu.core.drag.ScaleDragShadowBuilder
import ru.leadersofdigital.rosedu.core.drag.dragView
import ru.leadersofdigital.rosedu.core.extensions.clicks
import ru.leadersofdigital.rosedu.core.scene.SceneFrameLayout
import ru.leadersofdigital.rosedu.di.Qualifiers
import ru.leadersofdigital.rosedu.models.model.TypeDevice
import ru.leadersofdigital.rosedu.ui.device.DeviceFragment
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogDeviceSettings.DeviceSettingsDialogFragment
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings.NetworkSettingsDialogFragment
import ru.leadersofdigital.rosedu.ui.task.mainTask.state.MainTaskState
import ru.terrakok.cicerone.Router

class MainTaskFragment : BaseFragment<MainTaskState, MainTaskViewModel>(R.layout.fragment_main_task) {

    private val router
        get() = getKoin()
            .getOrCreateScope(Qualifiers.TASK_ROUTER_ID, Qualifiers.TASK_FLOW_SESSION)
            .get<Router>()

    companion object {
        fun newInstance() = MainTaskFragment()
    }

    override val viewModel: MainTaskViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.containerListDevice, DeviceFragment.newInstance())
                .commit()
        }

        containerScene.setOnDragListener { _, event ->
            when (event.action) {
                DragEvent.ACTION_DROP -> {
                    val clipPathId = event.clipData.getItemAt(0)
                    if (clipPathId != null) {
                        viewModel.handleDragParticle(clipPathId.text.toString(), event.x.toInt(), event.y.toInt())
                    }
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    // TODO что делать в адаптере
                }
            }
            true
        }
    }

    override fun renderState(state: MainTaskState) {
        containerScene.removeAllViews()
        val startPositionConnection = mutableListOf<SceneFrameLayout.DrawLineField>()
        var endPositionConnectionX: Int? = null
        var endPositionConnectionY: Int? = null
        state.itemScenes.forEach { scene ->
            val params = FrameLayout.LayoutParams(scene.width, scene.height)
            val container =
                LayoutInflater.from(requireContext()).inflate(R.layout.drop_view_item, containerScene, false)

            container.id = scene.subDevice.id
            params.topMargin = scene.positionY
            params.marginStart = scene.positionX
            container.ivDeviceImage.load(ContextCompat.getDrawable(requireContext(), scene.subDevice.type.resImage))
            containerScene.addView(container, params)
            container.setOnLongClickListener {
                if (scene.subDevice.type == TypeDevice.CONNECTION) return@setOnLongClickListener false
                val dragDate = ScaleDragShadowBuilder.createDate(
                    scene.subDevice.id
                )
                val dragImg = ScaleDragShadowBuilder(container, container.height, container.width)
                it.dragView(dragDate, dragImg)
                true
            }
            if (scene.subDevice.type == TypeDevice.RZA) {
                startPositionConnection.add(
                    SceneFrameLayout.DrawLineField(
                        scene.subDevice.id,
                        scene.positionX + (scene.width / 2),
                        scene.positionY + (scene.height - 70),
                        scene.positionX + (scene.width / 2),
                        scene.positionY + (scene.height - 70),
                        scene.height,
                        isDraw = scene.isOpenConnect
                    )
                )
                val backgroundImageConnection =
                    if (scene.isOpenConnect) R.drawable.bg_drag_menu_connection else R.drawable.cirlce_drag_menu
                container.ivMenuConnection.background =
                    ContextCompat.getDrawable(requireContext(), backgroundImageConnection)
                container.ivMenuConnection.isVisible = scene.isSelected
                container.ivMenuSetting.clicks {
                    viewModel.setDeviceSelected(scene.subDevice.id, scene.subDevice.type)
                    NetworkSettingsDialogFragment.newInstance().show(childFragmentManager, null)
                }
                container.ivMenuConnection.clicks {
                    viewModel.handleMenuConnection(scene.subDevice.id)
                }
                container.ivMenuDelete.clicks {
                    viewModel.handleDeleteScene(scene.subDevice.id)
                    containerScene.deleteDrawConnection(scene.subDevice.id)
                }
            } else if (scene.subDevice.type == TypeDevice.INDUSTRIAL_SWITCHES) {
                endPositionConnectionX = scene.positionX + 120
                endPositionConnectionY = scene.positionY + 120
                container.ivMenuDelete.clicks {
                    viewModel.handleDeleteScene(scene.subDevice.id)
                    containerScene.deleteDrawConnection(scene.subDevice.id)
                }
                container.ivMenuSetting.clicks {
                    viewModel.setDeviceSelected(scene.subDevice.id, scene.subDevice.type)
                    DeviceSettingsDialogFragment.newInstance().show(childFragmentManager, null)
                }
            }
            container.ivMenuSetting.isVisible = scene.isSelected
            container.ivMenuDelete.isVisible = scene.isSelected
            container.containerMenu.isVisible = scene.isSelected
            container.clicks {
                viewModel.selectScene(scene.subDevice.id)
            }
        }
        var stepSize = 60
        startPositionConnection.mapIndexed { index, drawLineField ->
            val stopX = endPositionConnectionX
            val stopY = endPositionConnectionY
            if (stopX != null && stopY != null) {
                val stepStopX = stopX + stepSize
                if (stepStopX >= stopX + drawLineField.witch) {
                    stepSize -= (stopX - drawLineField.witch)
                } else {
                    stepSize += 60
                }
                drawLineField.copy(
                    stopX = stepStopX,
                    stopY = stopY - 20
                )
            } else drawLineField
        }.forEach {
            containerScene.addDrawConnections(it)
        }
        containerScene.allDrawConnection()
    }

    override fun onBackPressed() {
        router.exit()
    }
}