package ru.leadersofdigital.rosedu.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ru.leadersofdigital.rosedu.R


abstract class BaseDialogFragment<ST, VM : BaseViewModel<ST>>() : DialogFragment() {

    abstract val viewModel: VM
    abstract val layoutRes: Int
        @LayoutRes get

     @androidx.annotation.StyleRes open val  styleRes = R.style.DialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, styleRes)
    }

    protected fun showDescriptionAlert(@StringRes title: Int, @StringRes description: Int) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(title)
            .setMessage(description)
            .setPositiveButton(resources.getString(R.string.common_understand)) { _,_ ->
            }.create().show()
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
