package com.airtribe.ridewise.model;

public class Rider {
    private int id;
    private String name;
    private Double location;

    public Rider(int id, String name, Double location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Rider{id=" + id + ", name='" + name + "', location=" + location + "}";
    }

}
