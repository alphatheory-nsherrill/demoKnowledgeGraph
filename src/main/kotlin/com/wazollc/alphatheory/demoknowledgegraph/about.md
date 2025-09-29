# Demo Knowledge Graph - Technical Overview

This is the master documentation for common technical concepts and patterns used throughout the Demo Knowledge Graph application.

---

## **EXTERNAL ACCESS** - High-Level Overview

### Application Overview
Comprehensive social messaging platform with integrated security monitoring and audit capabilities. Combines user communication features with enterprise-grade compliance and alerting systems.

---

## **INTERNAL ACCESS** - Implementation Details

### Spring Framework Implementation

#### Spring Services
The application uses Spring Boot's `@Service` annotation to create managed beans for business logic:
- Services handle core business operations
- Automatic dependency injection between components
- Singleton lifecycle management by Spring container

#### Spring Components
Uses `@Component` annotation for specialized beans:
- Background processing components
- Scheduled task handlers
- System monitoring services

#### Dependency Injection
Spring's dependency injection is used throughout:
- Constructor-based injection (recommended approach)
- Automatic wiring of dependencies
- Clean separation of concerns between layers

### Data Management

#### Data Classes
Kotlin data classes provide immutable data structures:
- Automatic generation of equals(), hashCode(), toString()
- Copy functionality for creating modified instances
- Concise syntax for data modeling

#### In-Memory Storage
Current implementation uses in-memory storage for demonstration:
- MutableList for simple collections
- MutableMap for key-value relationships
- Thread-safe considerations for concurrent access
- Easy migration path to persistent storage

### Common Data Types

#### Programming Data Types
- **Integer**: Used for unique identifiers and numeric values
- **String**: Text content, names, and descriptive fields
- **LocalDateTime**: Timestamp management with timezone awareness
- **ByteArray**: Binary data storage for file attachments
- **Lists**: Ordered collections of related items
- **MutableList**: Dynamic collections that can be modified
- **MutableMap**: Key-value stores for relationship mapping

#### Timestamp Management
Consistent use of LocalDateTime across the application:
- Automatic timestamp generation with LocalDateTime.now()
- Chronological sorting capabilities
- Timezone-neutral storage

### ID Management System

#### Unique Identifiers
All entities use Integer-based unique identifiers:
- Sequential ID generation for predictable ordering
- Simple lookup and reference mechanisms
- Easy debugging and troubleshooting

#### Auto-Generated IDs
Automatic ID generation pattern:
```kotlin
val newId = (existingItems.maxOfOrNull { it.id } ?: 0) + 1
```
- Ensures uniqueness within collections
- No external dependency on database sequences
- Deterministic ID assignment

### Scheduled Operations

#### Scheduled Tasks
Background processing using Spring's scheduling:
- `@Scheduled` annotation for automatic execution
- Cron expressions for precise timing control
- Asynchronous execution to avoid blocking main thread

#### Cron Jobs
Current implementation uses cron pattern "0 0/10 * * * *":
- Executes every 10 minutes
- Suitable for periodic monitoring and cleanup tasks
- Configurable through application properties

### Architecture Patterns

#### Service Layer Pattern
Clear separation between different architectural layers:
- Models: Data structure definitions
- Services: Business logic implementation
- Clean interfaces between audit and social modules

#### Event-Driven Architecture
Audit system demonstrates event-driven patterns:
- Event capture and storage
- Rule-based event processing
- Asynchronous alert generation

### Development Considerations

#### Demonstration vs Production
Current implementation optimized for learning and demonstration:
- In-memory storage for simplicity
- Console-based output for immediate feedback
- Simplified error handling
- Clear migration path to production-ready components