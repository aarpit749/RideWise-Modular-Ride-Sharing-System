package com.airtribe.ridewise.model;

public class Driver{

    private int id;
    private String name;
    private double currentLocation;
    private boolean available;

    public Driver(int id, String name, double currentLocation) {
        this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Driver{id=" + id + ", name='" + name + "', location=" + currentLocation + ", available=" + available + "}";
    }

}
