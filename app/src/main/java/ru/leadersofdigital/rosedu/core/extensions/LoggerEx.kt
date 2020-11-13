package ru.leadersofdigital.rosedu.core.extensions

import timber.log.Timber


inline fun <reified T : Any> T.printTypeClass() = this.let {
    Timber.d("type: ${it.javaClass.simpleName}")
}

inline fun <reified T> T.alsoDebugPrint(message: String = "log") = apply {
    Timber.d("$message: $this")
}

inline fun <reified T> T.printLog(message: String) = this.run { Timber.d(message) }