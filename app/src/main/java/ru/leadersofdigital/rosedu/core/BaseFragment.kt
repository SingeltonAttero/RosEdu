package ru.leadersofdigital.rosedu.core

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment<ST, VM : BaseViewModel<ST>>(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) {
            renderState(it)
        }
    }

    abstract fun renderState(state: ST)
}