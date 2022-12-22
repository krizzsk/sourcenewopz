package com.dmap.navigation.engine.event;

public class SpeedIconEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51959a;

    /* renamed from: b */
    private final int f51960b;

    /* renamed from: c */
    private final int f51961c;

    /* renamed from: d */
    private final int f51962d;

    /* renamed from: e */
    private final int f51963e;

    /* renamed from: f */
    private final float f51964f;

    /* renamed from: g */
    private final int f51965g;

    public SpeedIconEvent(int i, int i2, int i3, int i4, int i5, float f, int i6) {
        this.f51959a = i;
        this.f51960b = i2;
        this.f51961c = i3;
        this.f51962d = i4;
        this.f51963e = i5;
        this.f51964f = f;
        this.f51965g = i6;
    }

    public String toString() {
        return "SpeedIconEvent{updateType=" + this.f51959a + ", gpsSpeed=" + this.f51960b + ", speedIconKind=" + this.f51961c + ", averageSpeed=" + this.f51962d + ", averSpeedIconKind=" + this.f51963e + ", remanenDistance=" + this.f51964f + ", limitSpeed=" + this.f51965g + '}';
    }

    public int getUpdateType() {
        return this.f51959a;
    }

    public int getGpsSpeed() {
        return this.f51960b;
    }

    public int getSpeedIconKind() {
        return this.f51961c;
    }

    public int getAverageSpeed() {
        return this.f51962d;
    }

    public int getAverSpeedIconKind() {
        return this.f51963e;
    }

    public float getRemanenDistance() {
        return this.f51964f;
    }

    public int getLimitSpeed() {
        return this.f51965g;
    }
}
