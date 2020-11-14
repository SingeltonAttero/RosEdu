package ru.leadersofdigital.rosedu.core

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.leadersofdigital.rosedu.R


abstract class BaseDialogFragment<ST, VM : BaseViewModel<ST>>() : DialogFragment() {

    abstract val viewModel: VM
    abstract val layoutRes: Int
        @LayoutRes get

     @androidx.annotation.StyleRes open val  styleRes = R.style.DialogTheme

    //override fun onCreateView(
    //    inflater: LayoutInflater,
    //    container: ViewGroup?,
    //    savedInstanceState: Bundle?
    //): View? {
    //    return inflater.inflate(layoutRes, container, false)
    //}

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(layoutRes, null)

        return AlertDialog.Builder(requireContext(), styleRes)
            .setView(view)
            .create()
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
