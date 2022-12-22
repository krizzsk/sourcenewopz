package com.didi.map.outer.model;

public final class CompassDescriptor {
    private final BitmapDescriptor compassBack;
    private final BitmapDescriptor east;
    private final BitmapDescriptor north;
    private final BitmapDescriptor south;
    private final BitmapDescriptor west;

    public CompassDescriptor(BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2, BitmapDescriptor bitmapDescriptor3, BitmapDescriptor bitmapDescriptor4, BitmapDescriptor bitmapDescriptor5) {
        this.compassBack = bitmapDescriptor;
        this.north = bitmapDescriptor2;
        this.south = bitmapDescriptor3;
        this.east = bitmapDescriptor4;
        this.west = bitmapDescriptor5;
    }

    public BitmapDescriptor getCompassBack() {
        return this.compassBack;
    }

    public BitmapDescriptor getNorth() {
        return this.north;
    }

    public BitmapDescriptor getSouth() {
        return this.south;
    }

    public BitmapDescriptor getEast() {
        return this.east;
    }

    public BitmapDescriptor getWest() {
        return this.west;
    }
}
