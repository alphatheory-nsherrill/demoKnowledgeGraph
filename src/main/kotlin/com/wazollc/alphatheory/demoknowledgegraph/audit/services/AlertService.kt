package com.wazollc.alphatheory.demoknowledgegraph.audit.services

import com.wazollc.alphatheory.demoknowledgegraph.audit.models.AlertMessage
import com.wazollc.alphatheory.demoknowledgegraph.audit.models.AuditEvent
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class AlertService(
    private val auditService: AuditService
) {
    private val bannedUsersList = listOf(69, 420, 67)

    @Scheduled(cron = "0 0/10 * * * *")
    fun checkForIssues() {
        val last10 = auditService.last10Mins()
        val alertMessages = last10.mapNotNull {
            val message = runRules(it)
            if (message == null) return@mapNotNull null
            else return@mapNotNull AlertMessage(it, message)
        }
        if (alertMessages.isNotEmpty()) {
            println("BOOM! EXPLOSION! ERRORS!")
            println(alertMessages.joinToString())
        }
    }

    private fun runRules(event: AuditEvent): String? {
        if (event.user in bannedUsersList) return "banned user!"
        if (event.action.contains("message") && event.action.contains("bomb")) return "discussing bombs!"
        return null
    }
}