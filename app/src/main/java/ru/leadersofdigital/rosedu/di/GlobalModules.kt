package ru.leadersofdigital.rosedu.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.leadersofdigital.rosedu.core.ResourceManager
import ru.leadersofdigital.rosedu.models.MainTaskRepository
import ru.leadersofdigital.rosedu.ui.auth.AuthViewModel
import ru.leadersofdigital.rosedu.ui.auth.dialog.HelpViewModel
import ru.leadersofdigital.rosedu.ui.device.DeviceViewModel
import ru.leadersofdigital.rosedu.ui.task.TaskFlowViewModel
import ru.leadersofdigital.rosedu.ui.task.mainTask.MainTaskViewModel
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogDeviceSettings.DeviceSettingsViewModel
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogGooseSettings.GooseSettingsViewModel
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings.NetworkSettingsViewModel
import ru.leadersofdigital.rosedu.ui.task.testTask.QuizViewModel
import ru.leadersofdigital.rosedu.ui.tasksSelection.TasksSelectionViewModel
import ru.terrakok.cicerone.Cicerone

internal object GlobalModules {
    private val appModule = module {
        single { ResourceManager(get()) }

    }

    private val viewModelModule = module {
        viewModel { AuthViewModel(resourceManager = get()) }
        viewModel { TasksSelectionViewModel() }
        viewModel { TaskFlowViewModel() }
        viewModel { MainTaskViewModel(get()) }
        viewModel { QuizViewModel(get()) }
        viewModel { HelpViewModel(get()) }
        viewModel { NetworkSettingsViewModel(get(), get()) }
        viewModel { DeviceSettingsViewModel(get(), get()) }
        viewModel { DeviceViewModel(get()) }
        viewModel { GooseSettingsViewModel(get()) }
    }

    private val navigationModule = module {
        val global = Cicerone.create()
        single { global.navigatorHolder }
        single { global.router }

        scope(Qualifiers.TASK_FLOW_SESSION) {
            val taskFlowRouter = Cicerone.create()
            scoped { taskFlowRouter.router }
            scoped { taskFlowRouter.navigatorHolder }
        }
    }

    private val modelsModule = module {
        single { MainTaskRepository() }
    }

    val modules = listOf(
        appModule,
        viewModelModule,
        navigationModule,
        modelsModule
    )

}
