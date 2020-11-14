package ru.leadersofdigital.rosedu.di

import org.koin.core.qualifier.named

object Qualifiers {
    val TASK_FLOW_SESSION = named("TASK_FLOW_SESSION")
    const val TASK_ROUTER_ID = "1"
    const val TASK_NAVIGATOR_HOLDER_ID = "2"
}