# Social Models Package

This package contains data models for the social networking functionality in the Demo Knowledge Graph application.

---

## **EXTERNAL ACCESS** - High-Level Overview

### Social Messaging
Complete social messaging platform supporting user communication with contact management and file sharing capabilities.

### Contact Management
Users can maintain personal contact lists to organize and manage their connections within the system.

### File Attachments
Messages support optional file attachments, enabling users to share documents and media with their contacts.

---

## **INTERNAL ACCESS** - Implementation Details

### ContactInfo
**File:** `ContactInfo.kt:3`

A simple data class representing basic contact information. Contains:
- `contactInfoId`: Integer unique identifier for the contact
- `name`: String representing the contact's name

### ContactList
**File:** `ContactList.kt:3`

A data class representing a user's contact list. Contains:
- `contactUserId`: Integer identifier for the user who owns this contact list
- `contacts`: List of ContactInfo objects representing the user's contacts

### Message
**File:** `Message.kt:5`

A data class representing a message between contacts. Contains:
- `messageId`: Integer unique identifier for the message
- `senderContactId`: Integer ID of the message sender
- `recipientContactId`: Integer ID of the message recipient
- `message`: String content of the message
- `attachment`: Optional ByteArray for file attachments (nullable)
- `sent`: LocalDateTime timestamp when the message was sent (defaults to current time)

### Technical Details
- **Data Types**: Uses Integer for IDs, String for names and message content, LocalDateTime for timestamps, ByteArray for file attachments
- **Relationships**: ContactList contains List of ContactInfo objects to model user relationships
- **Purpose**: These models provide the core data structures for a social messaging system, supporting user contacts management and message exchange with optional file attachments.