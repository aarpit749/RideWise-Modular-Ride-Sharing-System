package com.airtribe.ridewise.strategy;
import com.airtribe.ridewise.model.Ride;

public class PeakHourFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(Ride ride) {
        return ride.getDistance() * 15;
    }

}
