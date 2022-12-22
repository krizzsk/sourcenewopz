package com.didi.sdk.home.model;

import com.didi.sdk.misconfig.model.CarGrop;

public class TopCarGroupWrapper {
    public CarGrop carGrop;
    public boolean isSelected = false;

    public TopCarGroupWrapper(CarGrop carGrop2) {
        this.carGrop = carGrop2;
    }
}
