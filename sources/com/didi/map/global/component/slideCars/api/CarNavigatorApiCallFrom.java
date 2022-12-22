package com.didi.map.global.component.slideCars.api;

import java.io.Serializable;

public enum CarNavigatorApiCallFrom implements Serializable {
    UNKNOWN("unknown"),
    MULITCARS_CURRENT_LOCATION("multi_cars_current_location"),
    MULITCARS_SPECIAL_LOCATION("multi_cars_SPECIAL_location"),
    SINGLECAR("single_car");
    
    private final String name;

    private CarNavigatorApiCallFrom(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(CarNavigatorApiCallFrom carNavigatorApiCallFrom) {
        return carNavigatorApiCallFrom != null && carNavigatorApiCallFrom.toString().equals(this.name);
    }
}
