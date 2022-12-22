package com.didichuxing.carsliding.model;

public class VectorCoordinate {

    /* renamed from: a */
    private double f46267a;

    /* renamed from: b */
    private double f46268b;

    /* renamed from: c */
    private float f46269c;

    /* renamed from: d */
    private long f46270d;

    public VectorCoordinate(double d, double d2, float f, long j) {
        this.f46267a = d;
        this.f46268b = d2;
        this.f46269c = f;
        this.f46270d = j;
    }

    public double getLat() {
        return this.f46267a;
    }

    public double getLng() {
        return this.f46268b;
    }

    public float getAngle() {
        return this.f46269c;
    }

    public long getTimeStamp() {
        return this.f46270d;
    }

    public String toString() {
        return "{lat=" + this.f46267a + ",lng=" + this.f46268b + ",angle=" + this.f46269c + ",timeStamp=" + this.f46270d + "}";
    }
}
