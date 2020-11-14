package ru.leadersofdigital.rosedu.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseFragment
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class MainActivity : AppCompatActivity() {

    private val router by inject<Router>()

    private val navigatorHolder by inject<NavigatorHolder>()

    private val navigator = object : SupportAppNavigator(this, R.id.container) {
        override fun setupFragmentTransaction(
            command: Command,
            currentFragment: androidx.fragment.app.Fragment?,
            nextFragment: androidx.fragment.app.Fragment?,
            fragmentTransaction: androidx.fragment.app.FragmentTransaction
        ) {
            fragmentTransaction.setReorderingAllowed(true)
        }
    }

    private val currentFragment: BaseFragment<*,*>?
        get() = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment<*,*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            router.newRootScreen(Screens.AuthScreen)
        }

    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }
}