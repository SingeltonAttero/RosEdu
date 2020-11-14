package ru.leadersofdigital.rosedu.models.model

data class GooseConnections(
    val ied2Enter1: MutableList<Boolean> = mutableListOf(false, false, false),
    val ied2Enter2: MutableList<Boolean> = mutableListOf(false, false, false),
    val ied2Enter3: MutableList<Boolean> = mutableListOf(false, false, false),

    val ied1Enter1: MutableList<Boolean> = mutableListOf(false, false, false),
    val ied1Enter2: MutableList<Boolean> = mutableListOf(false, false, false),
    val ied1Enter3: MutableList<Boolean> = mutableListOf(false, false, false)
)