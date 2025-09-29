package com.wazollc.alphatheory.demoknowledgegraph.social.models

import java.time.LocalDateTime

data class Message(
    val messageId: Int,
    val senderContactId: Int,
    val recipientContactId: Int,
    val message: String,
    val attachment: ByteArray? = null,
    val sent:LocalDateTime = LocalDateTime.now()
)
