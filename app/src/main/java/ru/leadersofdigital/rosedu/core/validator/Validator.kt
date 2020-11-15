package ru.leadersofdigital.rosedu.core.validator

import ru.leadersofdigital.rosedu.models.model.GooseConnections
import ru.leadersofdigital.rosedu.models.model.Quiz
import ru.leadersofdigital.rosedu.models.model.SubDevice
import ru.leadersofdigital.rosedu.models.model.TypeDevice

object Validator {
    fun validateAll(
        devices: List<SubDevice>,
        gooseConnections: GooseConnections,
        quizList: List<Quiz>
    ): ValidationResult {
        val deviceStatuses = devices.map { validateDevice(it) }
        val gooseConnectionStatus =  GooseValidator(gooseConnections).validate()
        val answeredQuizes = quizList.count { it.isValid() }
        val notAnsweredQuizes = quizList.count { !it.isValid() }
        val quizStatus =
            if (answeredQuizes / notAnsweredQuizes > 0.7) Status.Success else Status.QuizError(
                answeredQuizes,
                notAnsweredQuizes + answeredQuizes
            )
        return ValidationResult(deviceStatuses, gooseConnectionStatus, quizStatus)
    }

    private fun validateDevice(device: SubDevice): Status =
        when (device.type) {
            TypeDevice.RZA -> {
                Status.Success
            }
            TypeDevice.INDUSTRIAL_SWITCHES -> if (runValidation(
                    listOf(
                        IpAddressValidator(device.ipAddress),
                        MaskValidator(device.networkMask)
                    )
                )
            )
                Status.Success else Status.DevicesError(deviceId = device.id)
            TypeDevice.CONNECTION -> Status.Success
        }


    private fun runValidation(validator: List<ValidationWorker>) =
        validator.all { it.validate() }

}

interface ValidationWorker {
    fun validate(): Boolean
}

class IpAddressValidator(private val field: String?) : ValidationWorker {
    override fun validate(): Boolean {
        return !field.isNullOrEmpty() && !field.matches("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\$".toRegex())
    }
}

class MaskValidator(private val field: String?) : ValidationWorker {
    override fun validate(): Boolean {
        return !field.isNullOrEmpty() && !field.matches("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\$".toRegex())
    }
}

class GooseValidator(private val gooseConnections: GooseConnections) : ValidationWorker {
    override fun validate(): Boolean =
        gooseConnections.ied1Enter1.count { it } <=1 &&
                gooseConnections.ied1Enter2.count { it } <=1 &&
                gooseConnections.ied1Enter3.count { it } <=1 &&
                gooseConnections.ied2Enter1.count { it } <=1 &&
                gooseConnections.ied2Enter2.count { it } <=1 &&
                gooseConnections.ied2Enter3.count { it } <=1
}

sealed class Status {
    object Success : Status()
    data class DevicesError(val deviceId: Int) : Status()
    data class QuizError(val answeredQuizes: Int, val totalQuizes: Int) : Status()
}

data class ValidationResult(val deviceStatuses: List<Status>, val gooseConnectionStatus: Boolean, val quizStatus: Status)