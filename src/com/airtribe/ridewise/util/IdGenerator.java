package com.airtribe.ridewise.util;

public class IdGenerator {
    private static int riderId = 0;
    private static int driverId = 0;
    private static int rideId = 0;

    public static int nextRiderId() {
        return ++riderId;
    }

    public static int nextDriverId() {
        return ++driverId;
    }

    public static int nextRideId() {
        return ++rideId;
    }

}
