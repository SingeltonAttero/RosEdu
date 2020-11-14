package ru.leadersofdigital.rosedu.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment<ST, VM : BaseViewModel<ST>>() : DialogFragment() {

    abstract val viewModel: VM
    abstract val layoutRes: Int
        @LayoutRes get

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) {
            renderState(it)
        }
    }

    abstract fun renderState(state: ST)

    open fun onBackPressed() {}
}
