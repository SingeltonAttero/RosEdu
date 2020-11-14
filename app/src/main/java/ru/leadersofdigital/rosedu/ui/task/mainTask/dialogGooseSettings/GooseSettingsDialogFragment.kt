package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogGooseSettings

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.dialog_main_task_goose_settings.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.core.BaseDialogFragment
import ru.leadersofdigital.rosedu.ui.task.mainTask.dialogGooseSettings.state.GooseSettingsState
import ru.leadersofdigital.rosedu.R
class GooseSettingsDialogFragment : BaseDialogFragment<GooseSettingsState, GooseSettingsViewModel>() {

    override val viewModel: GooseSettingsViewModel by viewModel()

    override val layoutRes: Int = R.layout.dialog_main_task_goose_settings

    override val styleRes: Int = R.style.MaxHeightScreenDialog
    companion object {
        fun newInstance() = GooseSettingsDialogFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonApply.setOnClickListener { viewModel.updateConnections(
            listOf(cbEnter1ToExit1.isChecked, cbEnter1ToExit2.isChecked, cbEnter1ToExit3.isChecked),
            listOf(cbEnter2ToExit1.isChecked, cbEnter2ToExit2.isChecked, cbEnter2ToExit3.isChecked),
            listOf(cbEnter3ToExit1.isChecked, cbEnter3ToExit2.isChecked, cbEnter3ToExit3.isChecked),
            listOf(cbEnter1ToExit1v2.isChecked, cbEnter1ToExit2v2.isChecked, cbEnter1ToExit3v2.isChecked),
            listOf(cbEnter2ToExit1v2.isChecked, cbEnter2ToExit2v2.isChecked, cbEnter2ToExit3v2.isChecked),
            listOf(cbEnter3ToExit1v2.isChecked, cbEnter3ToExit2v2.isChecked, cbEnter3ToExit3v2.isChecked),
        )
            dismiss()
        }
    }

    override fun renderState(state: GooseSettingsState) {
        state.gooseConnections?.let {
            cbEnter1ToExit1.isChecked = it.ied1Enter1[0]
            cbEnter1ToExit2.isChecked = it.ied1Enter1[1]
            cbEnter1ToExit3.isChecked = it.ied1Enter1[2]

            cbEnter2ToExit1.isChecked = it.ied1Enter2[0]
            cbEnter2ToExit2.isChecked = it.ied1Enter2[1]
            cbEnter2ToExit3.isChecked = it.ied1Enter2[2]

            cbEnter3ToExit1.isChecked = it.ied1Enter3[0]
            cbEnter3ToExit2.isChecked = it.ied1Enter3[1]
            cbEnter3ToExit3.isChecked = it.ied1Enter3[2]

            cbEnter1ToExit1v2.isChecked = it.ied2Enter1[0]
            cbEnter1ToExit2v2.isChecked = it.ied2Enter1[1]
            cbEnter1ToExit3v2.isChecked = it.ied2Enter1[2]

            cbEnter2ToExit1v2.isChecked = it.ied2Enter2[0]
            cbEnter2ToExit2v2.isChecked = it.ied2Enter2[1]
            cbEnter2ToExit3v2.isChecked = it.ied2Enter2[2]

            cbEnter3ToExit1v2.isChecked = it.ied2Enter3[0]
            cbEnter3ToExit2v2.isChecked = it.ied2Enter3[1]
            cbEnter3ToExit3v2.isChecked = it.ied2Enter3[2]
        }
    }

}