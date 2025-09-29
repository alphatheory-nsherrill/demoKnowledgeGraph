package com.wazollc.alphatheory.demoknowledgegraph.social.services

import com.wazollc.alphatheory.demoknowledgegraph.social.models.Message
import org.springframework.stereotype.Service

@Service
class MessageService {
    private val allMessages = mutableListOf<Message>(); // stand in for database

    fun viewMessages(contactUserId: Int) =
        allMessages.filter { it.recipientContactId == contactUserId }
            .sortedByDescending { it.sent }

    fun viewSentMessages(contactUserId: Int) =
        allMessages.filter { it.senderContactId == contactUserId }
            .sortedByDescending { it.sent }

    fun sendMessage(senderId: Int, recipientId: Int, message: String, attachment: ByteArray? = null) = allMessages.add(
        Message(
            messageId = (allMessages.maxOfOrNull { it.messageId } ?: 0) + 1,
            senderContactId = senderId,
            recipientContactId = recipientId,
            message,
            attachment
        )
    )
}