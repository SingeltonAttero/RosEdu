package ru.leadersofdigital.rosedu.models.model

import androidx.annotation.DrawableRes
import ru.leadersofdigital.rosedu.R

data class Device(
    val id: Int,
    val name: String,
    val listSubDevice: List<SubDevice>,
    val type: TypeDevice,
)

data class SubDevice(
    val id: Int,
    val name: String,
    val type: TypeDevice,
    val macAddress: String? = null,
    val gcbName: String? = null,
    val maxTime: String? = null,
    val minTime: String? = null,
    val gooseId: String? = null,
    val appId: String? = null,
    val vlanId: String? = null,
    val ipAddress1: String? = null,
    val networkMask1: String? = null,
    val ipAddress2: String? = null,
    val networkMask2: String? = null,
    val typeConnection: TypeConnection = TypeConnection.TWISTED_PAIR
)

enum class TypeDevice(@DrawableRes val resImage: Int) {
    RZA(R.drawable.img_group_rsa_scene),
    INDUSTRIAL_SWITCHES(R.drawable.ic_switches_scene),
    CONNECTION(-1)
}

enum class TypeConnection {
    TWISTED_PAIR,
    OPTICAL_FIBER_O,
    OPTICAL_FIBER_M


}