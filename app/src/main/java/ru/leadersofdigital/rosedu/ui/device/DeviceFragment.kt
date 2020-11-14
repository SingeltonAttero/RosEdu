package ru.leadersofdigital.rosedu.ui.device

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_device.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.BaseFragment
import ru.leadersofdigital.rosedu.core.adapter.DeviceAdapterDelegate
import ru.leadersofdigital.rosedu.ui.device.state.DeviceState

class DeviceFragment : BaseFragment<DeviceState, DeviceViewModel>(R.layout.fragment_device) {

    companion object {
        fun newInstance() = DeviceFragment()
    }

    private val adapter by lazy { DeviceAdapterDelegate(viewModel::handleClickGroup).createDelegate() }

    override val viewModel: DeviceViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvDevice.adapter = adapter
    }

    override fun renderState(state: DeviceState) {
        tvTitleDevice.text = state.title
        adapter.items = state.listDevice
        adapter.notifyDataSetChanged()
    }
}