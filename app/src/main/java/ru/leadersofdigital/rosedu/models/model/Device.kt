package ru.leadersofdigital.rosedu.models.model

data class Device(
    val id: Int,
    val name: String,
    val listSubDevice: List<SubDevice>,
    val type: TypeDevice,

    val macAddress: String? = null,
    val gcbName: String? = null,
    val maxTime: String? = null,
    val minTime: String? = null,
    val gooseId: String? = null,
    val appId: String? = null,
    val vlanId: String? = null,

    val ipAddress: String? = null,
    val networkMask: String? = null,

)

data class SubDevice(
    val id: Int,
    val name: String
)

enum class TypeDevice {
    RZA,
    INDUSTRIAL_SWITCHES,
    CONNECTION
}