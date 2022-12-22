package com.didichuxing.carsliding.filter;

import com.didichuxing.carsliding.model.VectorCoordinate;

public class DistanceFilter implements VectorCoordinateFilter {
    public static final double DEFAULT_MIN_DISTANCE = 10.0d;

    /* renamed from: a */
    private static final double f46251a = 3.141592653589793d;

    /* renamed from: b */
    private double f46252b;

    public DistanceFilter(double d) {
        this.f46252b = d;
    }

    public DistanceFilter() {
        this.f46252b = 10.0d;
    }

    public boolean filter(VectorCoordinate vectorCoordinate, VectorCoordinate vectorCoordinate2) {
        return m33226a(vectorCoordinate.getLng(), vectorCoordinate.getLat(), vectorCoordinate2.getLng(), vectorCoordinate2.getLat()) < this.f46252b;
    }

    /* renamed from: a */
    private static double m33226a(double d, double d2, double d3, double d4) {
        double d5 = (d2 * 3.141592653589793d) / 180.0d;
        double d6 = ((21412.0d * (90.0d - d2)) / 90.0d) + 6356725.0d;
        double cos = (((d3 * 3.141592653589793d) / 180.0d) - ((d * 3.141592653589793d) / 180.0d)) * Math.cos(d5) * d6;
        double d7 = (((d4 * 3.141592653589793d) / 180.0d) - d5) * d6;
        return Math.sqrt((cos * cos) + (d7 * d7));
    }
}
