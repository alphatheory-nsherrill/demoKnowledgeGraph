package com.wazollc.alphatheory.demoknowledgegraph.audit.services

import com.wazollc.alphatheory.demoknowledgegraph.audit.models.AuditEvent
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AuditService {
    private val events = mutableListOf<AuditEvent>()

    fun auditEvent(event: AuditEvent) = events.add(event)

    fun last10Mins() = events.filter { it.timestamp.isAfter(LocalDateTime.now().minusMinutes(10L)) }
}