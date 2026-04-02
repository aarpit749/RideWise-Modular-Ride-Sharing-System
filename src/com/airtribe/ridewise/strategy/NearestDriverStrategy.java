package com.airtribe.ridewise.strategy;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy {

    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {

        Driver nearest = null;
        double minDist = Double.MAX_VALUE;

        for (Driver d : drivers) {
            if (!d.isAvailable()) continue;

            double distance = Math.abs(d.getCurrentLocation() - rider.getLocation());
            if (distance < minDist) {
                minDist = distance;
                nearest = d;
            }
        }
        return nearest;
    }

}
