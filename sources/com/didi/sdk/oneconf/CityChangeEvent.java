package com.didi.sdk.oneconf;

import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.event.Event;

public class CityChangeEvent implements Event {
    public static final String EVENT_GUARANA_CITY_CHANGE = "guarana_city_change";

    /* renamed from: a */
    private Address f36860a;

    /* renamed from: b */
    private String f36861b;

    public CityChangeEvent(String str, Address address) {
        this.f36861b = str;
        this.f36860a = address;
    }

    public String getEvent() {
        return this.f36861b;
    }

    public void setEvent(String str) {
        this.f36861b = str;
    }

    public Address getAddress() {
        return this.f36860a;
    }
}
