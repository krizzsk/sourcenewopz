package com.didi.map.sdk.departure.internal.data.store;

public class DepartureDataStore {

    /* renamed from: a */
    private static final String f28154a = "DepartureDataStore";

    /* renamed from: b */
    private static DepartureDataStore f28155b;

    /* renamed from: c */
    private boolean f28156c;

    private DepartureDataStore() {
    }

    public static DepartureDataStore getInstance() {
        if (f28155b == null) {
            synchronized (DepartureDataStore.class) {
                if (f28155b == null) {
                    f28155b = new DepartureDataStore();
                }
            }
        }
        return f28155b;
    }

    public boolean IsFirstLaunch() {
        if (!this.f28156c) {
            return false;
        }
        this.f28156c = false;
        return true;
    }
}
