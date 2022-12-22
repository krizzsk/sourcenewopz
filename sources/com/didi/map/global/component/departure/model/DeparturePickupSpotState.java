package com.didi.map.global.component.departure.model;

public class DeparturePickupSpotState {

    /* renamed from: a */
    private boolean f25197a;

    /* renamed from: b */
    private boolean f25198b;

    public boolean isValid() {
        return this.f25197a;
    }

    public void setValid(boolean z) {
        this.f25197a = z;
        if (!z) {
            this.f25198b = false;
        }
    }

    public boolean isChecked() {
        return this.f25198b;
    }

    public void setChecked(boolean z) {
        this.f25198b = z;
    }
}
