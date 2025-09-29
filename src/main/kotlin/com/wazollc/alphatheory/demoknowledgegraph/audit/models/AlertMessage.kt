package com.wazollc.alphatheory.demoknowledgegraph.audit.models

import java.time.LocalDateTime

data class AlertMessage(
    val event: AuditEvent,
    val infraction: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
