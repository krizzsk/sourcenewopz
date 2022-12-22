package com.dmap.navigation.engine.event;

public class ParallelRoadEvent extends NaviEvent {
    public static final int MAIN_ROAD = 3;
    public static final int SERVING_ROAD = 4;

    /* renamed from: a */
    private final int f51946a;

    /* renamed from: b */
    private final int f51947b;

    public ParallelRoadEvent(int i, int i2) {
        this.f51946a = i;
        this.f51947b = i2;
    }

    public String toString() {
        return "ParallelRoadEvent{updateType=" + this.f51946a + ", type=" + this.f51947b + '}';
    }

    public int getUpdateType() {
        return this.f51946a;
    }

    public int getType() {
        return this.f51947b;
    }
}
