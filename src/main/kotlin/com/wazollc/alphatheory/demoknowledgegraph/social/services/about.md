# Social Services Package

This package contains service classes that handle social networking functionality including messaging and contact management.

---

## **EXTERNAL ACCESS** - High-Level Overview

### User Messaging
Complete messaging platform allowing users to send and receive messages with their contacts, including support for file attachments and message history.

### Contact Management
Full user account and contact relationship management, enabling users to create accounts, manage their contact lists, and maintain social connections.

### Messaging Platform
Integrated social messaging system that combines user management with real-time communication capabilities.

---

## **INTERNAL ACCESS** - Implementation Details

### MessageService
**File:** `MessageService.kt:7`

A Spring service responsible for managing messages between contacts. Features:
- `allMessages`: In-memory storage for all messages using a mutable list
- `viewMessages(contactUserId)`: Returns received messages for a user, sorted by most recent first
- `viewSentMessages(contactUserId)`: Returns sent messages for a user, sorted by most recent first
- `sendMessage(senderId, recipientId, message, attachment)`: Creates and stores a new message with:
  - Auto-generated unique message ID
  - Support for optional file attachments
  - Automatic timestamp assignment

### ContactService
**File:** `ContactService.kt:8`

A Spring service that manages user accounts and contact relationships. Features:
- **Dependency**: Injected `AuditService` for tracking user operations
- **Storage**:
  - `allUsers`: In-memory list of all ContactInfo objects
  - `allContacts`: Map linking user IDs to their contact lists
- **User Management**:
  - `createUser(name)`: Creates a new user with auto-generated ID and empty contact list
  - `deleteUser(contactId)`: Removes user and cleans up all references in other users' contact lists
- **Contact Management**:
  - `addContact(userId, contactId)`: Adds a contact to a user's contact list
  - `removeContact(userId, contactId)`: Removes a contact from a user's contact list

### Technical Implementation
- **Framework**: Spring Boot services using `@Service` annotation
- **Storage**: In-memory storage using MutableList and MutableMap for demonstration purposes
- **ID Management**: Auto-generated unique identifiers for users and messages
- **Audit Integration**: ContactService integrates with AuditService for tracking user operations
- **Data Sorting**: Messages are sorted by timestamp (most recent first) for optimal user experience