# Object Relationships – RideWise

## 1. Rider → Ride
- One Rider can request multiple rides over time
- At any moment, only one ride is active

Relationship: One-to-Many (logical)

---

## 2. Driver → Ride
- A Driver can serve many rides over time
- A Driver can be associated with only one ride at a time

Relationship: One-to-Many (temporal)

---

## 3. Ride → Rider
- Every Ride must have exactly one Rider

Relationship: One-to-One

---

## 4. Ride → Driver
- A Ride may or may not have a Driver initially
- Once assigned, the Driver remains until completion

Relationship: Optional One-to-One

---

## 5. Ride → FareReceipt
- A FareReceipt is generated only after ride completion

Relationship: One-to-One (post-completion)

---

## 6. Service Relationships
- RideService collaborates with:
    - DriverService
    - RideMatchingStrategy
    - FareStrategy

Follows Law of Demeter by avoiding deep chaining.

---

## Summary
The object graph is intentionally simple to:
- Improve readability
- Avoid tight coupling
- Support future scalability