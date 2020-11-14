package ru.leadersofdigital.rosedu.core.adapter

import androidx.annotation.DrawableRes
import ru.leadersofdigital.rosedu.models.model.TypeDevice

sealed class DeviceItemState(open val id: Int) {

    data class Group(
        override val id: Int,
        val title: String,
        @DrawableRes val icon: Int,
        val isOpenGroup: Boolean = false
    ) : DeviceItemState(id)

    data class Device(
        override val id: Int,
        val title: String,
        val type: TypeDevice,
        @DrawableRes val dragImage: Int
    ) : DeviceItemState(id)
}