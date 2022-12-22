package com.didi.map.global.component.departure.model;

public class CircleParam {
    public int fillColor;
    public double radiusInMeters;
    public int strokeColor;
    public int strokeWidthInPixel;

    public CircleParam() {
    }

    public CircleParam(double d, int i, int i2, int i3) {
        this.radiusInMeters = d;
        this.fillColor = i;
        this.strokeColor = i2;
        this.strokeWidthInPixel = i3;
    }
}
