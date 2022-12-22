package com.didi.map.sdk.nav.prediction;

import java.util.Locale;

public class SctxPredictionOmegaData {
    public final float cover = -1.0f;
    public double originLat;
    public double originLng;
    public double predictLat;
    public double predictLng;
    public long timestamp;

    public SctxPredictionOmegaData(double d, double d2, double d3, double d4, long j) {
        this.predictLat = d3;
        this.predictLng = d4;
        this.originLat = d;
        this.originLng = d2;
        this.timestamp = j;
    }

    public boolean isPredicted() {
        if (!m20144a(this.predictLat) || !m20144a(this.predictLng) || !m20144a(this.originLat) || !m20144a(this.originLng)) {
            return false;
        }
        return !m20145a(this.predictLat, this.originLat) || !m20145a(this.predictLng, this.originLng);
    }

    /* renamed from: a */
    private boolean m20144a(double d) {
        return Math.abs(d) > 1.0E-6d;
    }

    /* renamed from: a */
    private boolean m20145a(double d, double d2) {
        return Double.doubleToLongBits(d) == Double.doubleToLongBits(d2);
    }

    public String getOutput() {
        return String.format(Locale.getDefault(), "{%.6f,%.6f;%.6f,%.6f;%d;%.2f}", new Object[]{Double.valueOf(this.originLat), Double.valueOf(this.originLng), Double.valueOf(this.predictLat), Double.valueOf(this.predictLng), Long.valueOf(this.timestamp), Float.valueOf(-1.0f)});
    }
}
