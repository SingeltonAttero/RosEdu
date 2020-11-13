package ru.leadersofdigital.rosedu.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.leadersofdigital.rosedu.core.ResourceManager
import ru.leadersofdigital.rosedu.ui.main.MainViewModel
import ru.terrakok.cicerone.Cicerone

internal object GlobalModules {
    private val appModule = module {
        single { ResourceManager(get()) }

    }

    private val viewModelModule = module {
        viewModel { MainViewModel(resourceManager = get()) }
    }

    private val navigationModule = module {
        val global = Cicerone.create()
        single { global.navigatorHolder }
        single { global.router }
    }

    private val modelsModule = module {

    }

    val modules = listOf(
        appModule,
        viewModelModule,
        navigationModule,
        modelsModule
    )

}
