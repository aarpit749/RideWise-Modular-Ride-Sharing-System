# RideWise – Project Requirements

## 1. Overview
RideWise is a console-based ride-hailing application designed to demonstrate
Low-Level Design (LLD) concepts using Java. The focus of the project is on
object-oriented design, SOLID principles, and extensible architecture rather
than real-world geolocation accuracy.

---

## 2. Functional Requirements

### 2.1 Rider Management
- Register a new rider
- Fetch rider details using rider ID

### 2.2 Driver Management
- Register a new driver
- Update driver availability
- View all available drivers

### 2.3 Ride Management
- Request a ride
- Assign a driver using a matching strategy
- Calculate fare using a pricing strategy
- Complete an ongoing ride
- Track ride status:
    - REQUESTED
    - ASSIGNED
    - COMPLETED
    - CANCELLED

---

## 3. Non-Functional Requirements
- Low coupling between classes
- High cohesion within services
- Easy extensibility for:
    - Driver matching logic
    - Fare calculation logic
- Readable and maintainable codebase

---

## 4. Assumptions
- Location is represented as a numeric value (1D) for simplicity
- One rider can have only one active ride
- Payment is simulated via fare calculation only
