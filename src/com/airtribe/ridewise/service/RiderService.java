package com.airtribe.ridewise.service;
import com.airtribe.ridewise.model.Rider;
import java.util.HashMap;

public class RiderService {

    private HashMap<Integer, Rider> riders = new HashMap<>();

    public void register(Rider rider) {
        riders.put(rider.getId(), rider);
    }

    public Rider get(int id) {
        return riders.get(id);
    }

}
