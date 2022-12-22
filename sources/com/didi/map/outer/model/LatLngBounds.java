package com.didi.map.outer.model;

public final class LatLngBounds {
    public final LatLng northeast;
    public final LatLng southwest;

    /* renamed from: a */
    private static double m19935a(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* renamed from: b */
    private static double m19937b(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public static final class Builder {

        /* renamed from: F */
        private double f27935F = Double.POSITIVE_INFINITY;

        /* renamed from: G */
        private double f27936G = Double.NEGATIVE_INFINITY;

        /* renamed from: H */
        private double f27937H = Double.NaN;

        /* renamed from: I */
        private double f27938I = Double.NaN;

        public Builder include(LatLng latLng) {
            this.f27935F = Math.min(this.f27935F, latLng.latitude);
            this.f27936G = Math.max(this.f27936G, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.f27937H)) {
                this.f27937H = d;
                this.f27938I = d;
            } else if (!m19941a(d)) {
                if (LatLngBounds.m19939c(this.f27937H, d) < LatLngBounds.m19940d(this.f27938I, d)) {
                    this.f27937H = d;
                } else {
                    this.f27938I = d;
                }
            }
            return this;
        }

        public Builder include(Iterable<LatLng> iterable) {
            if (iterable != null) {
                for (LatLng include : iterable) {
                    include(include);
                }
            }
            return this;
        }

        /* renamed from: a */
        private boolean m19941a(double d) {
            double d2 = this.f27937H;
            double d3 = this.f27938I;
            return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
        }

        public LatLngBounds build() {
            return new LatLngBounds(new LatLng(this.f27935F, this.f27937H), new LatLng(this.f27936G, this.f27938I));
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean contains(LatLng latLng) {
        return m19938b(latLng.latitude) && m19936a(latLng.longitude);
    }

    public LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (!m19936a(d3)) {
            if (m19935a(d2, d3) < m19937b(d, d3)) {
                d2 = d3;
            } else {
                d = d3;
            }
        }
        return new LatLngBounds(new LatLng(min, d2), new LatLng(max, d));
    }

    public LatLngBounds including(LatLngBounds latLngBounds) {
        return including(latLngBounds.northeast).including(latLngBounds.southwest);
    }

    public LatLng getCenter() {
        return new LatLng((this.southwest.latitude + this.northeast.latitude) / 2.0d, (this.southwest.longitude + this.northeast.longitude) / 2.0d);
    }

    /* renamed from: b */
    private boolean m19938b(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: a */
    private boolean m19936a(double d) {
        if (this.southwest.longitude <= this.northeast.longitude) {
            if (this.southwest.longitude > d || d > this.northeast.longitude) {
                return false;
            }
            return true;
        } else if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
            return true;
        } else {
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

    /* renamed from: c */
    static double m19939c(double d, double d2) {
        return m19935a(d, d2);
    }

    /* renamed from: d */
    static double m19940d(double d, double d2) {
        return m19937b(d, d2);
    }

    public String toString() {
        return "LatLngBounds{southwest=" + this.southwest + ", northeast=" + this.northeast + '}';
    }
}
