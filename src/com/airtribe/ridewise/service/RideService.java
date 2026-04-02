package com.airtribe.ridewise.service;

import com.airtribe.ridewise.exception.NoDriverAvailableException;
import com.airtribe.ridewise.model.*;
import com.airtribe.ridewise.strategy.FareStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;

import java.util.Collection;
import java.util.HashMap;

public class RideService {

    private HashMap<Integer, Ride> rides = new HashMap<>();

    private RideMatchingStrategy matchingStrategy;
    private FareStrategy fareStrategy;
    private DriverService driverService;

    public RideService(RideMatchingStrategy matchingStrategy,
                       FareStrategy fareStrategy,
                       DriverService driverService) {
        this.matchingStrategy = matchingStrategy;
        this.fareStrategy = fareStrategy;
        this.driverService = driverService;
    }

    public Ride requestRide(Rider rider, double distance)
            throws NoDriverAvailableException {
        
        if (rider == null) {
            throw new IllegalArgumentException("Rider cannot be null");
        }

        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }

        Ride ride = new Ride(rides.size() + 1, rider, distance);
        rides.put(ride.getId(), ride);

        Driver driver = matchingStrategy.findDriver(rider, driverService.listAvailableDrivers());

        if (driver == null)
            throw new NoDriverAvailableException("No drivers available at the moment.");

        ride.assignDriver(driver);
        driverService.updateAvailability(driver.getId(), false);

        return ride;
    }

    public FareReceipt completeRide(int rideId) {
        Ride ride = rides.get(rideId);

        if (ride == null || ride.getStatus() != RideStatus.ASSIGNED)
            return null;

        ride.complete();
        driverService.updateAvailability(ride.getDriver().getId(), true);

        double fare = fareStrategy.calculateFare(ride);
        return new FareReceipt(rideId, fare);
    }

    public Collection<Ride> getRides() {
        return rides.values();
    }

}
