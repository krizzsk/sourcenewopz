package com.didi.map.sdk.departure;

import com.didi.map.sdk.departure.internal.DepartureCoreManager;

public class DepartureFactory {
    public static IDepartureCompContract createCoreManager() {
        return new DepartureCoreManager();
    }
}
