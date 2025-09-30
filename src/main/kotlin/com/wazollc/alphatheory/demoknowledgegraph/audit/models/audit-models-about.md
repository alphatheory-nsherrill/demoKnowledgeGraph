# Audit Models Package

This package contains data models for the audit system in the Demo Knowledge Graph application.

---

## **EXTERNAL ACCESS** - High-Level Overview

### Audit Functionality
The system provides comprehensive audit trail capabilities to track user activities and generate security alerts when violations occur. This ensures compliance monitoring and helps maintain system security.

### Alert System
Automated alerting system that monitors user actions and generates notifications for potential security or compliance issues.

---

## **INTERNAL ACCESS** - Implementation Details

### AuditEvent
**File:** `AuditEvent.kt:5`

A data class representing an auditable event in the system. Contains:
- `action`: String describing the action that was performed
- `user`: Integer identifier for the user who performed the action
- `timestamp`: LocalDateTime when the event occurred (defaults to current time)

### AlertMessage
**File:** `AlertMessage.kt:5`

A data class representing an alert message generated from audit events. Contains:
- `event`: Associated AuditEvent that triggered the alert
- `infraction`: String describing the type of infraction or violation
- `timestamp`: LocalDateTime when the alert was created (defaults to current time)

### Technical Details
- **Data Types**: Uses LocalDateTime for timestamps, Integer for user IDs, String for actions and infractions
- **Purpose**: These models work together to provide audit trail functionality and alerting capabilities for the knowledge graph system. AuditEvent captures system activities, while AlertMessage represents notifications about potential security or compliance issues.