package ru.leadersofdigital.rosedu.core.adapter

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import kotlinx.android.synthetic.main.item_device.*
import kotlinx.android.synthetic.main.item_group_device.*
import ru.leadersofdigital.rosedu.R
import ru.leadersofdigital.rosedu.core.drag.ScaleDragShadowBuilder
import ru.leadersofdigital.rosedu.core.drag.dragView
import ru.leadersofdigital.rosedu.core.extensions.clicks
import ru.leadersofdigital.rosedu.models.model.TypeDevice

class DeviceAdapterDelegate(private val click: (item: DeviceItemState) -> Unit = {}) {

    fun createDelegate() = AsyncListDifferDelegationAdapter(
        DiffDevice,
        AdapterDelegatesManager(
            createGroup(click),
            createDevice(click)
        )
    )

    private fun createGroup(click: (item: DeviceItemState) -> Unit) =
        adapterDelegateLayoutContainer<DeviceItemState.Group, DeviceItemState>(R.layout.item_group_device) {
            itemView.clicks { click.invoke(item) }
            bind {
                ivIconDevice.setImageDrawable(ContextCompat.getDrawable(context, item.icon))
                tvTitleGroupDevice.text = item.title
                val openIcon = if (item.isOpenGroup) ContextCompat.getDrawable(context, R.drawable.ic_open_down)
                else ContextCompat.getDrawable(context, R.drawable.ic_expand_group)
                ivOpenSubList.setImageDrawable(openIcon)
            }
        }

    private fun createDevice(click: (item: DeviceItemState) -> Unit) =
        adapterDelegateLayoutContainer<DeviceItemState.Device, DeviceItemState>(R.layout.item_device) {
            itemView.setOnLongClickListener {
                if (item.type == TypeDevice.CONNECTION) return@setOnLongClickListener false
                val dragDate = ScaleDragShadowBuilder.createDate(
                    item.id
                )
                val dragImg = ScaleDragShadowBuilder(itemView, itemView.height, itemView.width)
                it.dragView(dragDate, dragImg)
                true
            }
            bind {
                tvTitleDevice.text = item.title
            }
        }


}

object DiffDevice : DiffUtil.ItemCallback<DeviceItemState>() {
    override fun areItemsTheSame(oldItem: DeviceItemState, newItem: DeviceItemState): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DeviceItemState, newItem: DeviceItemState): Boolean {
        return oldItem == newItem
    }
}