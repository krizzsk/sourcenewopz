package com.didi.common.map.model;

import java.util.ArrayList;
import java.util.List;

public final class LatLngBounds {
    public List<LatLng> latLngList;
    public final LatLng northeast;
    public final LatLng southwest;

    /* renamed from: c */
    private static double m7353c(double d, double d2) {
        return (((d * 1000000.0d) - (d2 * 1000000.0d)) + 3.6E8d) % 3.6E8d;
    }

    /* renamed from: d */
    private static double m7354d(double d, double d2) {
        return (((d2 * 1000000.0d) - (d * 1000000.0d)) + 3.6E8d) % 3.6E8d;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean contains(LatLng latLng) {
        return m7350a(latLng.latitude) && m7352b(latLng.longitude);
    }

    public LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (!m7352b(d3)) {
            if (m7353c(d2, d3) < m7354d(d, d3)) {
                d2 = d3;
            } else {
                d = d3;
            }
        }
        return new LatLngBounds(new LatLng(min, d2), new LatLng(max, d));
    }

    /* renamed from: a */
    private boolean m7350a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: b */
    private boolean m7352b(double d) {
        int i = (this.southwest.longitude > this.northeast.longitude ? 1 : (this.southwest.longitude == this.northeast.longitude ? 0 : -1));
        int i2 = (this.southwest.longitude > d ? 1 : (this.southwest.longitude == d ? 0 : -1));
        if (i > 0) {
            return i2 <= 0 || d <= this.northeast.longitude;
        }
        if (i2 > 0 || d > this.northeast.longitude) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (!this.southwest.equals(latLngBounds.southwest) || !this.northeast.equals(latLngBounds.northeast)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static double m7347a(double d, double d2) {
        return m7353c(d, d2);
    }

    /* renamed from: b */
    static double m7351b(double d, double d2) {
        return m7354d(d, d2);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        if (d3 > d2) {
            d2 += 360.0d;
        }
        return new LatLng(d, (d2 + d3) / 2.0d);
    }

    public static final class Builder {

        /* renamed from: a */
        private double f10826a = Double.POSITIVE_INFINITY;

        /* renamed from: b */
        private double f10827b = Double.NEGATIVE_INFINITY;

        /* renamed from: c */
        private double f10828c = Double.NaN;

        /* renamed from: d */
        private double f10829d = Double.NaN;
        private final List<LatLng> latLngList = new ArrayList();

        public double roundValue(double d) {
            return ((double) ((int) (d * 1000000.0d))) / 1000000.0d;
        }

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            LatLng latLng2 = new LatLng(roundValue(latLng.latitude), roundValue(latLng.longitude));
            if (!Double.isNaN(latLng2.latitude) && !Double.isNaN(latLng2.longitude)) {
                this.latLngList.add(latLng2);
                this.f10826a = Math.min(this.f10826a, latLng2.latitude);
                this.f10827b = Math.max(this.f10827b, latLng2.latitude);
                double d = latLng2.longitude;
                if (Double.isNaN(this.f10828c)) {
                    this.f10828c = d;
                    this.f10829d = d;
                } else if (!content(d)) {
                    if (LatLngBounds.m7347a(this.f10828c, d) < LatLngBounds.m7351b(this.f10829d, d)) {
                        this.f10828c = d;
                    } else {
                        this.f10829d = d;
                    }
                }
            }
            return this;
        }

        public Builder include(List<LatLng> list) {
            if (list == null) {
                return this;
            }
            this.latLngList.addAll(list);
            for (LatLng include : list) {
                include(include);
            }
            return this;
        }

        private boolean content(double d) {
            double d2 = this.f10828c;
            double d3 = this.f10829d;
            if (d2 > d3) {
                return d2 <= d || d <= d3;
            }
            if (d2 > d || d > d3) {
                return false;
            }
        }

        public LatLngBounds build() {
            LatLngBounds latLngBounds = new LatLngBounds(new LatLng(this.f10826a, this.f10828c), new LatLng(this.f10827b, this.f10829d));
            latLngBounds.m7349a(this.latLngList);
            return latLngBounds;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7349a(List<LatLng> list) {
        this.latLngList = list;
    }
}
