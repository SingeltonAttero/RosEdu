package ru.leadersofdigital.rosedu.models.model

import androidx.annotation.DrawableRes
import ru.leadersofdigital.rosedu.R

data class Device(
    val id: Int,
    val name: String,
    val listSubDevice: List<SubDevice>,
    val type: TypeDevice
)

data class SubDevice(
    val id: Int,
    val name: String,
    val type: TypeDevice
)

enum class TypeDevice(@DrawableRes val resImage: Int) {
    RZA(R.drawable.img_group_rsa_scene),
    INDUSTRIAL_SWITCHES(R.drawable.ic_switches_scene),
    CONNECTION(-1)
}