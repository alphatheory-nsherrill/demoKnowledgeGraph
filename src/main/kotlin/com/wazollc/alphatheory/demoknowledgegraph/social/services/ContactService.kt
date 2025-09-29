package com.wazollc.alphatheory.demoknowledgegraph.social.services

import com.wazollc.alphatheory.demoknowledgegraph.audit.services.AuditService
import com.wazollc.alphatheory.demoknowledgegraph.social.models.ContactInfo
import org.springframework.stereotype.Service

@Service
class ContactService(
    private val auditService: AuditService
) {
    private val allUsers = mutableListOf<ContactInfo>() // stand in for database
    private val allContacts = mutableMapOf<Int, List<Int>>() // stand in for database

    fun createUser(name: String) {
        val newUser = ContactInfo(
            (allUsers.maxOfOrNull { it.contactInfoId } ?: 0) + 1,
            name
        )
        allUsers.add(newUser)
        allContacts[newUser.contactInfoId] = listOf()
    }

    fun deleteUser(contactId: Int) {
        allContacts.remove(contactId)
        allContacts.toMap().forEach {
            val v = it.value
            if (v.contains(contactId)) {
                allContacts[it.key] = v - contactId
            }
        }
        allUsers.removeIf { it.contactInfoId == contactId }
    }

    fun addContact(userId:Int, contactId:Int){
        allContacts[userId] = allContacts[userId]!! + contactId
    }
    fun removeContact(userId:Int, contactId: Int){
        allContacts[userId] = allContacts[userId]!!.filter { it != contactId }
    }
}