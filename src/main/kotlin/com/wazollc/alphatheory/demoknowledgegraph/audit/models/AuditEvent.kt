package com.wazollc.alphatheory.demoknowledgegraph.audit.models

import java.time.LocalDateTime

data class AuditEvent(val action: String, val user: Int, val timestamp: LocalDateTime = LocalDateTime.now())