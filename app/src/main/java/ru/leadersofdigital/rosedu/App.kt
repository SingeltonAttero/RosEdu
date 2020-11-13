package ru.leadersofdigital.rosedu

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.leadersofdigital.rosedu.di.GlobalModules
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)

            modules(GlobalModules.modules)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}