# Audit Services Package

This package contains service classes that handle audit event processing and alerting functionality.

---

## **EXTERNAL ACCESS** - High-Level Overview

### Security Monitoring
Real-time security monitoring system that continuously watches user activities and automatically generates alerts when suspicious behavior or policy violations are detected.

### Automated Alerting
The system runs scheduled security checks and provides immediate notifications when security rules are violated, ensuring rapid response to potential threats.

---

## **INTERNAL ACCESS** - Implementation Details

### AuditService
**File:** `AuditService.kt:8`

A Spring service responsible for managing audit events. Features:
- `events`: In-memory storage for audit events using a mutable list
- `auditEvent(event)`: Adds an audit event to the storage
- `last10Mins()`: Returns all events that occurred within the last 10 minutes

This service provides basic audit trail functionality by collecting and retrieving recent system events.

### AlertService
**File:** `AlertService.kt:9`

A Spring component that monitors audit events and generates alerts based on security rules. Features:
- **Dependency**: Injected `AuditService` for accessing recent events
- **Banned Users List**: Maintains a list of user IDs (69, 420, 67) that are flagged
- `checkForIssues()`: Scheduled method (runs every 10 minutes) that:
  - Retrieves events from the last 10 minutes
  - Applies security rules to each event
  - Generates alerts for violations
  - Outputs alert messages to console
- `runRules(event)`: Private method that applies security rules:
  - Flags events from banned users
  - Detects potentially dangerous content (messages containing "bomb")

### Technical Implementation
- **Framework**: Uses Spring Boot with `@Service` and `@Component` annotations
- **Scheduling**: Cron-based scheduled tasks running every 10 minutes
- **Storage**: In-memory storage using MutableList for demonstration purposes
- **Security Rules**: Rule-based system for detecting violations and dangerous content
- **Output**: Console-based alert notifications with formatted messages