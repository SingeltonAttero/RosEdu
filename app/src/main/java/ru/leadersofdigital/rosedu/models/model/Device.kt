package ru.leadersofdigital.rosedu.models.model

data class Device(
    val id: Int,
    val name: String,
    val listSubDevice: List<SubDevice>,
    val type: TypeDevice
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