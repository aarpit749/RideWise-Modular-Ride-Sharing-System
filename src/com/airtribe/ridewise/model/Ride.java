package com.airtribe.ridewise.model;

public class Ride {
    private int id;
    private RideStatus status;
    private Rider rider;
    private Driver driver;
    private double distance;

    public Ride(int id, Rider rider, double distance) {
        this.id = id;
        this.rider = rider;
        this.distance = distance;
        this.status = RideStatus.REQUESTED;
    }

    public int getId() {
        return id;
    }

    public RideStatus getStatus() {
        return status;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getDistance() {
        return distance;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.status = RideStatus.ASSIGNED;
    }

    public void complete() {
        this.status = RideStatus.COMPLETED;
    }

    @Override
    public String toString() {
        return "Ride{id=" + id + ", rider=" + rider.getName() +
                ", driver=" + (driver != null ? driver.getName() : "None") +
                ", distance=" + distance + ", status=" + status + "}";
    }

}
