package ru.leadersofdigital.rosedu.ui

import androidx.fragment.app.Fragment
import ru.leadersofdigital.rosedu.ui.main.MainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object MainScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return MainFragment.newInstance()
        }
    }

}