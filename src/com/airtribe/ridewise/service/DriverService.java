package com.airtribe.ridewise.service;

import com.airtribe.ridewise.model.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DriverService {

    private HashMap<Integer, Driver> drivers = new HashMap<>();

    public void register(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public List<Driver> listAvailableDrivers() {
        List<Driver> list = new ArrayList<>();
        for (Driver d : drivers.values()) {
            if (d.isAvailable()) list.add(d);
        }
        return list;
    }

    public void updateAvailability(int id, boolean available) {
        Driver d = drivers.get(id);
        if (d != null) d.setAvailable(available);
    }

}
