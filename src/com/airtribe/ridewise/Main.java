package com.airtribe.ridewise;

import com.airtribe.ridewise.exception.NoDriverAvailableException;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.FareReceipt;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.service.DriverService;
import com.airtribe.ridewise.service.RideService;
import com.airtribe.ridewise.service.RiderService;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.FareStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;
import com.airtribe.ridewise.util.IdGenerator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RiderService riderService = new RiderService();
        DriverService driverService = new DriverService();

        RideMatchingStrategy matchingStrategy = new NearestDriverStrategy();
        FareStrategy fareStrategy = new DefaultFareStrategy();

        RideService rideService = new RideService(matchingStrategy, fareStrategy, driverService);

        while (true) {
            System.out.println("\n==== RIDEWISE MENU ====");
            System.out.println("1. Add Rider");
            System.out.println("2. Add Driver");
            System.out.println("3. View Available Drivers");
            System.out.println("4. Request Ride");
            System.out.println("5. Complete Ride");
            System.out.println("6. View All Rides");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Name: ");
                        String rn = sc.next();
                        System.out.print("Location: ");
                        double rLoc = sc.nextDouble();

                        Rider rider = new Rider(IdGenerator.nextRiderId(), rn, rLoc);
                        riderService.register(rider);
                        System.out.println("Rider added.");
                        break;

                    case 2:
                        System.out.print("Name: ");
                        String dn = sc.next();
                        System.out.print("Location: ");
                        double dLoc = sc.nextDouble();

                        Driver driver = new Driver(IdGenerator.nextDriverId(), dn, dLoc);
                        driverService.register(driver);
                        System.out.println("Driver added.");
                        break;

                    case 3:
                        System.out.println(driverService.listAvailableDrivers());
                        break;

                    case 4:
                        System.out.print("Rider ID: ");
                        int rid = sc.nextInt();
                        Rider r = riderService.get(rid);

                        System.out.print("Distance: ");
                        double dist = sc.nextDouble();
                        if(r == null){
                            System.out.println("Rider not found. Please retry.");
                        }else {
                            Ride ride = rideService.requestRide(r, dist);
                            System.out.println("Ride Assigned: " + ride);
                        }
                        break;

                    case 5:
                        System.out.print("Ride ID: ");
                        int rideId = sc.nextInt();

                        FareReceipt receipt = rideService.completeRide(rideId);

                        if (receipt == null)
                            System.out.println("Ride not found or not assigned.");
                        else
                            System.out.println(receipt);
                        break;

                    case 6:
                        System.out.println(rideService.getRides());
                        break;

                    case 7:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Please choose between 1–7.");
                        break;

                }

            } catch (NoDriverAvailableException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

}
