# Class Model – RideWise

This document describes the core domain classes of the RideWise system,
their responsibilities, and how they collaborate with each other.
The goal of the class model is to represent the problem domain clearly
and support extensibility and maintainability.

---

## 1. Domain Entities (Model Layer)

### Rider
Represents a user who requests rides.

Attributes:
- id : int
- name : String
- location : double

Responsibility:
- Holds rider-specific data only
- Does not contain business logic

---

### Driver
Represents a driver available to serve rides.

Attributes:
- id : int
- name : String
- currentLocation : double
- available : boolean

Responsibility:
- Tracks availability and location
- Keeps driver data isolated from ride orchestration

---

### Ride
Represents a single ride request and its lifecycle.

Attributes:
- id : int
- rider : Rider
- driver : Driver
- distance : double
- status : RideStatus

Behavior:
- assignDriver(Driver)
- complete()

Responsibility:
- Maintains ride state
- Acts as the core aggregate connecting Rider and Driver

---

### FareReceipt
Represents the fare generated after ride completion.

Attributes:
- rideId : int
- amount : double
- generatedAt : LocalDateTime

Responsibility:
- Acts as a result object after ride completion
- Keeps billing information separate from Ride

---

## 2. Enumerations

### RideStatus
Represents the lifecycle state of a ride.

Values:
- REQUESTED
- ASSIGNED
- COMPLETED
- CANCELLED

---

## 3. Service Layer Classes

### RiderService
Responsibility:
- Register riders
- Retrieve rider details using ID

This service ensures that rider-related logic is centralized
and follows the Single Responsibility Principle.

---

### DriverService
Responsibility:
- Register drivers
- Manage driver availability
- Provide list of available drivers

Keeps driver state management isolated from ride logic.

---

### RideService
Responsibility:
- Handle ride requests
- Assign drivers using a matching strategy
- Calculate fare using a pricing strategy
- Complete rides

RideService acts as the orchestrator and depends only on abstractions
(strategy interfaces), ensuring loose coupling.

---

## 4. Strategy Interfaces

### RideMatchingStrategy
Defines how a driver is selected for a ride.

Method:
- findDriver(Rider, List<Driver>)

Implementations:
- NearestDriverStrategy
- LeastActiveDriverStrategy

---

### FareStrategy
Defines how fare is calculated.

Method:
- calculateFare(Ride)

Implementations:
- DefaultFareStrategy
- PeakHourFareStrategy

---

## 5. Utility and Exception Classes

### IdGenerator
Responsibility:
- Generate unique IDs for Rider, Driver, and Ride
- Centralizes ID creation to avoid duplication

---

### NoDriverAvailableException
Responsibility:
- Indicates failure when no drivers are available
- Allows graceful error handling without breaking flow

---

## 6. Design Summary

- Domain entities are kept free of business logic
- Services coordinate use cases
- Strategies provide extensibility
- The model adheres to SOLID principles
- The structure supports future enhancements without major refactoring