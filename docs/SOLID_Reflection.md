# SOLID Principles – Reflection

## 1. Single Responsibility Principle (SRP)
Each class in the system has a single responsibility.
Examples:
- RiderService handles only rider-related operations
- DriverService manages drivers
- RideService handles ride orchestration

---

## 2. Open/Closed Principle (OCP)
The system is open for extension but closed for modification.
New fare calculation or driver matching logic can be added by implementing:
- FareStrategy
- RideMatchingStrategy
  without modifying existing services.

---

## 3. Liskov Substitution Principle (LSP)
All strategy implementations can replace their interfaces without changing
the behavior of RideService.

Example:
- DefaultFareStrategy
- PeakHourFareStrategy

---

## 4. Interface Segregation Principle (ISP)
Small and focused interfaces are used.
There are no large, unused methods forced on implementing classes.

---

## 5. Dependency Inversion Principle (DIP)
High-level modules (RideService) depend on abstractions, not concrete classes.
Strategies are injected via constructor.

---

## Outcome
Applying SOLID principles resulted in:
- Cleaner architecture
- Easier testing
- Better extensibility