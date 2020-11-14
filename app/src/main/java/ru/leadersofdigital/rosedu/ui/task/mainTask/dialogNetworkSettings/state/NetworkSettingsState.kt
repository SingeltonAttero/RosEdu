package ru.leadersofdigital.rosedu.ui.task.mainTask.dialogNetworkSettings.state

data class NetworkSettingsState(
    val deviceTitle: String,
    val deviceType: String
) {
    companion object {
        fun initial() = NetworkSettingsState("", "")
    }
}